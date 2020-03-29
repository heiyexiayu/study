package ioc.reader;

import ioc.BeanDefinition;
import ioc.BeanReference;
import ioc.PropertyValue;
import ioc.resource.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 解析xml
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void readXML(String location) throws Exception{
        //创建一个资源加载器
        ResourceLoader resourceLoader=new ResourceLoader();
        //从资源加载器获取输入流
        InputStream inputStream=resourceLoader.getResource(location).getInputStream();
        //获取文档建造工厂
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //创建文档建造器
        DocumentBuilder builder=factory.newDocumentBuilder();
        //文档建造器解析输入流，返回文档对象
        Document d =builder.parse(inputStream);
        //注入bean容器
        registerBeanDefinition(d);
        //关闭流
        inputStream.close();
    }

    private void registerBeanDefinition(Document d) {
        //获取文档根元素
        Element root=d.getDocumentElement();
        //解析元素所有节点 并添加入容器
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        //获取根元素所有子元素
        NodeList nodeList=root.getChildNodes();
        //遍历元素
        for(int i=0;i<nodeList.getLength();i++){
            //获取指定元素
            Node node =nodeList.item(i);
            if(node instanceof Element){
                //强转
                Element element=(Element)node;
                //解析指定节点
                processBeanDefinition(element);
            }
        }
    }

    /**
     * 解析指定节点
     * @param element
     */
    private void processBeanDefinition(Element element) {
        //获取给定元素name属性
        String name=element.getAttribute("name");
        //获取指定元素的class属性
        String className=element.getAttribute("class");
        //创建一个bean对象
        BeanDefinition definition=new BeanDefinition();
        //设置beanDeinition的全限定类名
        definition.setClassName(className);
        //向beanDefiniton注入配置文件中的成员变量值
        addPropertyValues(element,definition);
        //向容器中注册bean
    }

    //属性值绑定
    private void addPropertyValues(Element element, BeanDefinition definition) {
        NodeList nodeList=element.getElementsByTagName("property");
        for(int i=0;i<nodeList.getLength();i++){
            //获取指定节点
            Node node=nodeList.item(i);
            if(node instanceof  Element){
                Element proELe=(Element)node;
                //获取元素的名字和属性值
                String name =proELe.getAttribute("name");
                String value=proELe.getAttribute("value");
                //判断value的值
                if(null!=value&&value.length()>0){
                    definition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    //引用
                    String ref=proELe.getAttribute("ref");
                    if(null==ref||ref.length()==0){
                        throw new IllegalArgumentException("Configuration problem: <property> element for property \n" +
                                "                    + name + \"' must specify a ref or value\"");
                    }
                    //不为空,则创建一个bean引用，构造参数为名称， 引用中的bean并未设置，还是null
                    BeanReference beanReference=new BeanReference(name);
                    definition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }
        }
    }
}
