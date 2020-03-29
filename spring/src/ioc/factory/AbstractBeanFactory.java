package ioc.factory;

import ioc.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 容器
     */
    private Map<String,BeanDefinition>map=new HashMap<>();

    /**
     * 根据bean的名称获取bean，没有抛异常
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition=map.get(name);
        if(null==beanDefinition){
            throw new IllegalArgumentException("no bean named "+name+"is defined !");
        }
        Object bean =beanDefinition.getBean();
        if(null==bean){
            bean =doCreatebean(beanDefinition);
        }
        return bean;
    }

    /**
     * 创建bean
     * @param beanDefinition
     * @return
     */
   protected abstract Object doCreatebean(BeanDefinition beanDefinition) throws Exception ;

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition)  throws Exception{
        Object bean =doCreatebean(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name,beanDefinition);
    }
}
