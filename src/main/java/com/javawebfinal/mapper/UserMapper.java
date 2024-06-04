package com.javawebfinal.mapper;

import com.javawebfinal.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    // 查询所有用户
    @Select("SELECT * FROM fi_user")
    List<User> getAllUser();
    // 根据用户名查询用户id
    @Select("SELECT id FROM fi_user WHERE username = #{username}")
    Integer getUserIdByUsername(String username);
    // 根据用户id查询用户
    @Select("SELECT * FROM fi_user WHERE id = #{id}")
    User getUserById(int id);
    // 根据用户名和密码查询用户
    @Select("SELECT * FROM fi_user WHERE username = #{username} AND password = #{password}")
    User getUserByUsernameAndPassword(String username, String password);
    // 添加用户
    @Insert("INSERT INTO fi_user (username, password, balance, tel, address) VALUES (#{username}, #{password}, #{balance}, #{tel}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id, role")
    Boolean AddUser(User user);
    //修改用户名
    @Update("UPDATE fi_user SET username = #{username} WHERE id = #{id}")
    Boolean updateUsername(int id, String username);
    // 修改用户密码
    @Update("UPDATE fi_user SET password = #{password} WHERE id = #{id}")
    Boolean updatePassword(int id, String password);
    // 修改用户余额
    @Update("UPDATE fi_user SET balance = #{balance} WHERE id = #{id}")
    Boolean updateBalance(int id, double balance);
    // 修改用户角色
    @Update("UPDATE fi_user SET role = #{role} WHERE id = #{id}")
    Boolean updateRole(int id, int role);
    // 修改用户地址信息
    @Update("UPDATE fi_user SET tel = #{tel}, address = #{address} WHERE id = #{id}")
    Boolean updateUserAddress(int id, String tel, String address);
    // 删除用户
    @Delete("DELETE FROM fi_user WHERE id = #{id}")
    Boolean deleteUser(int id);
}