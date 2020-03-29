package ioc.reader;

import ioc.BeanDefinition;
import ioc.reader.BeanDefinitionReader;
import ioc.resource.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 注册bean的容器
     */
    private Map<String, BeanDefinition>registory;
    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registory=new HashMap<>();
        this.resourceLoader=resourceLoader;
    }

    /**
     * 获取容器
     * @return
     */
    public Map<String,BeanDefinition>getRegistory(){
        return registory;
    }

    /**
     * 获得资源加载器
     * @return
     */
    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
}
