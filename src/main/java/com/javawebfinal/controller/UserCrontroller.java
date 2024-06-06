package com.javawebfinal.controller;


import com.javawebfinal.model.Result;
import com.javawebfinal.model.User;
import com.javawebfinal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserCrontroller {
    @Autowired
    private UserService userService;

    @RequestMapping
    public String index() {
        return "user";
    }

    @ResponseBody
    @GetMapping("/getUser")
    public Result getUser(Integer uid) {
        log.info("UserCrontroller.getUser() " + uid);
        User user = userService.getSelf(uid);
        user.setPassword(null);
        return Result.success(user);
    }
    
    @ResponseBody
    @PutMapping("/updateUser")
    public Result updateUser(User user) {
        return Result.success();
    }
}