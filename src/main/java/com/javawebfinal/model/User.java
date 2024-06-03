package com.javawebfinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private double balance; // 余额
    private String tel;
    private String address;
    private int role; // 角色，0：普通用户，1：管理员
}