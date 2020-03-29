package ioc.resource;

import java.net.URL;

public class ResourceLoader {
    /**
     * 加载指定位置资源
     * @param location
     * @return
     */
    public ResourceUrl getResource(String location){
        URL url=this.getClass().getClassLoader().getResource(location);
        return new ResourceUrl(url);
    }
}
