package ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合
 */
public class PropertyValues {

    private final List<PropertyValue>propertyValueList=new ArrayList<>();


    public PropertyValues(){}

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList(){
        return propertyValueList;
    }
}
