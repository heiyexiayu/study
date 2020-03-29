package ioc.factory;

import ioc.BeanDefinition;

public interface BeanFactory {
    /**
     * 获取bean
     * @return
     * @throws Exception
     */
    Object getBean(String name)throws Exception;
    void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;
}
