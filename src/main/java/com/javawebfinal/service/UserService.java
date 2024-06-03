package com.javawebfinal.service;

import com.javawebfinal.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return User
     */
    User login(String username, String password);

    /**
     * 注册
     *
     * @param user
     * @return int
     */
    int register(User user);

    /**
     * 列出所有用户
     *
     * @return List<User>
     */
    List<User> listAll();

    /**
     * 列出个人信息
     * 
     * @param id
     */
    User listSelf(int id);
    
    /**
     * 修改用户信息
     *
     * @param user
     */
    int updateUserInfo(User user);

    /**
     * 修改密码
     * 
     * @param id, password
     */
    int updatePassword(int id, String password);

    /**
     * 修改余额
     * 
     * @param id, balance
     */
    int updateBalance(int id, double balance);

    /**
     * 删除用户
     *
     * @param id
     */
    int deleteUser(int id);

}