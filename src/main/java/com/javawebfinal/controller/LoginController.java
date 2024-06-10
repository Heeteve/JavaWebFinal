package com.javawebfinal.controller;

import com.javawebfinal.model.User;
import com.javawebfinal.model.Result;
import com.javawebfinal.service.UserService;
import com.javawebfinal.util.JwtUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    public Result login(String username, String password, HttpServletResponse resp) {
        log.info("User login: {}" ,username);
        User user = userService.login(username, password);
        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            claims.put("role", user.getRole());
            String jwt = JwtUtils.generateJWT(claims);
            //log.info("jwt: {}", jwt);

            Cookie cookie = new Cookie("jwt", jwt);
            cookie.setPath("/");
            cookie.setMaxAge(3600*24);
            resp.addCookie(cookie);
            
            log.info("User logged in: {}", user.getUsername());
            return Result.success(jwt);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(String username, String password, String tel, String address) {
        log.info("User register {} {} {}", username, tel, address);
        // 检查格式
        if (username == null || username.length() < 3 || username.length() > 20) {
            return Result.error("用户名长度应为3-20");
        }
        if (password == null || password.length() < 6 || password.length() > 20) {
            return Result.error("密码长度应为6-20");
        }
        if (tel == null || tel.length() != 11) {
            return Result.error("请填写正确的手机号");
        }
        if (userService.register(username, password, tel, address)) {
            return Result.success("注册成功");
        } else {
            return Result.error("注册失败");
        }
    }
}