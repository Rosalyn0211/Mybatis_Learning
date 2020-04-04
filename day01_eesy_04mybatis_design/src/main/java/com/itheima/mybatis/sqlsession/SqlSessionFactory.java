package com.itheima.mybatis.sqlsession;

/**
 * @author Rosalyn
 * @create 2020-03-27 12:04
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
