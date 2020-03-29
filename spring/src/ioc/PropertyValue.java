package ioc;

/**
 * 属性
 */
public class PropertyValue {

    private String name;

    private Object value;


    public PropertyValue(String name,Object object){
        this.name=name;
        this.value=object;
    }


    public String getName(){
        return name;
    }

    public Object getValue(){
        return value;
    }
}
