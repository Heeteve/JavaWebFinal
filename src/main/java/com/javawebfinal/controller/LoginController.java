package com.javawebfinal.controller;

import com.javawebfinal.model.User;
import com.javawebfinal.model.Result;
import com.javawebfinal.service.UserService;
import com.javawebfinal.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(String username, String password) {
        log.info("User login " + username + " " + password);
        User user = userService.login(username, password);
        log.info("user: " + user);
        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            claims.put("role", user.getRole());
            String jwt = JwtUtils.generateJWT(claims);
            log.info("jwt: " + jwt);
            return Result.success(jwt);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(String username, String password, String tel, String address) {
        log.info("User register " + username + " " + password + " " + tel + " " + address);
        if (userService.register(username, password, tel, address)) {
            return Result.success("注册成功");
        } else {
            return Result.error("注册失败");
        }
    }
}