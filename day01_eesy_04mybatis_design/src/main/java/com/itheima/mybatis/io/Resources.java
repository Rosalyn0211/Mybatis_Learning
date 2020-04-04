package com.itheima.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 * @author Rosalyn
 * @create 2020-03-27 11:57
 */
public class Resources {

    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
