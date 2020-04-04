package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

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
     * 查询所有账户，并且带有用户名称和地址信息。
     * @return
     */
    List<AccountUser> findAllAccount();

}
