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
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
