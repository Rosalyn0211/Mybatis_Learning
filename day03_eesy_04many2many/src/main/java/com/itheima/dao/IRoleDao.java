package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-04-01 22:18
 */
public interface IRoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
