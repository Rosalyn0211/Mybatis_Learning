package com.itheima.mybatis.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询的注解
 * @author Rosalyn
 * @create 2020-03-27 17:43
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /**
     * 配置Sql语句
     * @return
     */
    String value();
}
