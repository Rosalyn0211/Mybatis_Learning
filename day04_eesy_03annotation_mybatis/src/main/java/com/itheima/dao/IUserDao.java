package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-04-03 19:51
 * mybatis中针对CRUD有四个注解
 * @Select @Insert @ Update @Delete
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username = #{username},sex = #{sex},birthday = #{birthday},address = #{address} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    @Select("select * from user where username like #{username}")
    List<User> findByName(String username);

    @Select("select count(*) from user")
    int findTotal();
}
