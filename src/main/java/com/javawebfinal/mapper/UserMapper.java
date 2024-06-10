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

    // 修改用户信息
    @Update("UPDATE fi_user SET username = #{username}, password = #{password}, tel = #{tel}, address = #{address} WHERE id = #{id}")
    Boolean updateUser(User user);

    // 管理员修改用户信息
    @Update("UPDATE fi_user SET username = #{username}, password = #{password}, balance = #{balance}, tel = #{tel}, address = #{address}, role = #{role} WHERE id = #{id}")
    Boolean updateUserAdmin(User user);

    // 删除用户
    @Delete("DELETE FROM fi_user WHERE id = #{id}")
    Boolean deleteUser(int id);

    // 查询余额
    @Select("SELECT balance FROM fi_user WHERE id = #{id}")
    double getBalanceByUid(int id);

    // 修改用户余额
    @Update("UPDATE fi_user SET balance = #{balance} WHERE id = #{id}")
    Boolean updateBalance(int id, double balance);
}