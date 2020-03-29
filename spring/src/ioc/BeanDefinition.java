package ioc;

public class BeanDefinition {
    /**
     * bean
     */
    private Object bean;
    /**
     * bean 全限定名
     */
    private String className;

    /**
     * bean的class对象
     */
    private Class beanClass;

    /**
     * 类属性集合
     */
    private PropertyValues propertyValues;

    /**
     * 获取bean对象
     */
    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getClassName() {
        return className;
    }

    /**
     * 通过反射生成class对象
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
        try {
            beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }


    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
