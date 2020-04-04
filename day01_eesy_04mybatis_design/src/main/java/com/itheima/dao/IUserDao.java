package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.mybatis.annontation.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * @author Rosalyn
 * @create 2020-03-26 13:27
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

}
