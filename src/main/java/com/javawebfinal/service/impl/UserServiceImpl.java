package com.javawebfinal.service.impl;

import com.javawebfinal.mapper.UserMapper;
import com.javawebfinal.model.User;
import com.javawebfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public int register(User user) {
        return userMapper.AddUser(user);
    }

    @Override
    public List<User> listAll() {
        return userMapper.getAllUser();
    }

    @Override
    public User listSelf(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateUserAddress(user.getId(), user.getTel(), user.getAddress());
    }

    @Override
    public int updatePassword(int id, String password) {
        return userMapper.updatePassword(id, password);
    }

    @Override
    public int updateBalance(int id, double balance) {
        return userMapper.updateBalance(id, balance);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
}