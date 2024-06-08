package com.javawebfinal.service.impl;

import com.javawebfinal.mapper.UserMapper;
import com.javawebfinal.model.User;
import com.javawebfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public Boolean register(String username, String password, String tel, String address) {
        // 检查是否已存在该用户
        if (userMapper.getUserIdByUsername(username) != null) {
            return false;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setTel(tel);
            user.setAddress(address);
            user.setBalance(0.0);
            return userMapper.AddUser(user);
        }
    }

    @Override
    public List<User> listAll() {
        return userMapper.getAllUser();
    }

    @Override
    public User getSelf(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Boolean updateUserInfo(User user) {
        // 检查password是否为空
        if (Objects.equals(user.getPassword(), "")) {
            String password = userMapper.getUserById(user.getId()).getPassword();
            user.setPassword(password);
        }
        return userMapper.updateUser(user);
    }

    @Override
    public Boolean updatePassword(int id, String password) {
        return true;
    }

    @Override
    public Boolean updateBalance(int id, double balance) {
        return true;
    }

    @Override
    public Boolean deleteUser(int id) {
        return true;
    }
}