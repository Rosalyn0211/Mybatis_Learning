package com.itheima.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis的配置类
 * @author Rosalyn
 * @create 2020-03-27 12:22
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }

    private Map<String,Mapper> mappers = new HashMap<String, Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uesrname) {
        this.username = uesrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

