package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-03-28 12:49
 *  用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();



    /**
     * 根据Id查询用户信息
     * @param uesrId
     * @return
     */
    User findById(Integer uesrId);


}
