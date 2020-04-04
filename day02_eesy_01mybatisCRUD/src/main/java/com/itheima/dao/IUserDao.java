package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import javax.management.Query;
import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-03-28 12:49
 *  用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param uesrId
     */
    void deleteUser(Integer uesrId);

    /**
     * 根据Id查询用户信息
     * @param uesrId
     * @return
     */
    User findById(Integer uesrId);

    /**
     * 模糊查询
     * @param uesrname
     * @return
     */
    List<User> findByName(String uesrname);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

}
