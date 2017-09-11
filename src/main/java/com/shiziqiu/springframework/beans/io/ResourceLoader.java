package com.shiziqiu.springframework.beans.io;
import java.net.URL;
/**
 * 获取资源 
 * @title : ResourceLoader
 * @author : shiziqiu
 * @date : 2017年9月11日 下午1:37:10
 * @Fun :
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
