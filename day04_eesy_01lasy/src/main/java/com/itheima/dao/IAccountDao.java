package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author Rosalyn
 * @create 2020-04-01 11:22
 */
public interface IAccountDao {

    /**
     * 查询所有账户,以及当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();


    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);

}
