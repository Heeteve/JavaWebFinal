package com.javawebfinal.controller;


import com.javawebfinal.model.Result;
import com.javawebfinal.model.User;
import com.javawebfinal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping
    public String index() {
        return "user";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "user-admin";
    }
    
    @ResponseBody
    @GetMapping("/getUser")
    public Result getUser(Integer uid) {
        log.info("UserController.getUser(uid {})", uid);
        User user = userService.getSelf(uid);
        user.setPassword(null);
        return Result.success(user);
    }

    @ResponseBody
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        log.info("UserController.updateUser(user {})", user);
        // 检查格式
        if (user.getUsername() == null || user.getUsername().length() < 3 || user.getUsername().length() > 20) {
            return Result.error("用户名长度应为3-20");
        }
        if (!Objects.equals(user.getPassword(), "")) {
            if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
                return Result.error("密码长度应为6-20");
            }
        }
        if (user.getTel() == null || user.getTel().length() != 11) {
            return Result.error("请填写正确的手机号");
        }
        
        if (userService.updateUserInfo(user)) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }
    
    @ResponseBody
    @GetMapping("/admin/getUser")
    public Result getUserAdmin(){
        log.info("UserController.getUserAdmin()");
        List<User> userList = userService.listAll();
        userList.forEach(user -> user.setPassword(null));
        return Result.success(userList);
    }
    
    @ResponseBody
    @PostMapping("/admin/updateUser")
    public Result updateUserAdmin(@RequestBody User user) {
        log.info("UserController.updateUserAdmin(user {})", user);
        // 检查格式
        if (user.getUsername() == null || user.getUsername().length() < 3 || user.getUsername().length() > 20) {
            return Result.error("用户名长度应为3-20");
        }
        if (!Objects.equals(user.getPassword(), "")) {
            if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
                return Result.error("密码长度应为6-20");
            }
        }
        if (user.getTel() == null || user.getTel().length() != 11) {
            return Result.error("请填写正确的手机号");
        }
        
        if (userService.updateUserInfoAdmin(user)) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }
    
    @ResponseBody
    @PostMapping("/admin/addUser")
    public Result addUser(@RequestBody User user) {
        log.info("UserController.addUser(user {})", user);
        user.setBalance(0.0);
        if (userService.addUser(user)) {
            return Result.success("添加成功");
        } else {
            return Result.error("添加失败");
        }
    }

    @ResponseBody
    @GetMapping("/admin/deleteUser")
    public Result deleteUser(Integer uid) {
        log.info("UserController.deleteUser(uid {})", uid);
        if (userService.deleteUser(uid)) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }
    
}