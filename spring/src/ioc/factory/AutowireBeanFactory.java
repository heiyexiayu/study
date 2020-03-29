package ioc.factory;

import ioc.BeanDefinition;
import ioc.BeanReference;
import ioc.PropertyValue;

import java.lang.reflect.Field;

public class AutowireBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreatebean(BeanDefinition beanDefinition) throws Exception {
        Object bean =beanDefinition.getBeanClass().newInstance();
        addPropertyValue(bean,beanDefinition);
        return bean;
    }

    /**
     * 向bean注入实例
     * @param bean
     * @param beanDefinition
     */
    private void addPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
       //循环给定bean的属性集合
        for(PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValueList()){
            //获取对应属性
            Field  declaredFiled=bean.getClass().getDeclaredField(propertyValue.getName());
            //设置访问权限
            declaredFiled.setAccessible(true);
            //获取属性中的对象
            Object value=propertyValue.getValue();
            //判断是不是BeanReference对象
            if(value instanceof BeanReference){
                //将属性对象转成BeanReference对象    此时的beanReference并没有初始化
                BeanReference beanReference=(BeanReference)value;
                //调用父类的AbstractBeanFactory的getBean方法，根据bean引用的名称获取实例  递归实现引用bean的创建
                value=getBean(beanReference.getName());
            }
            //反射注入
            declaredFiled.set(bean,value);
        }
    }
}
