package com.javawebfinal.service;

import com.javawebfinal.model.User;

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
     * @param username
     * @param password
     * @param tel
     * @param address
     */
    Boolean register(String username, String password, String tel, String address);

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
    User getSelf(int id);
    
    /**
     * 修改用户信息
     *
     * @param user
     */
    Boolean updateUserInfo(User user);

    /**
     * 管理员修改用户信息
     * @param user
     */
    Boolean updateUserInfoAdmin(User user);
    
    /**
     * 修改密码
     * 
     * @param id
     * @param password
     */
    Boolean updatePassword(int id, String password);

    /**
     * 删除用户
     *
     * @param id
     */
    Boolean deleteUser(int id);

    
    /**
     * 添加用户
     * @param user
     */
    Boolean addUser(User user);
}