package com.javawebfinal.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    void getUserByUsernameAndPassword() {
        System.out.println(userMapper.getUserByUsernameAndPassword("admin", "1"));
    }
}