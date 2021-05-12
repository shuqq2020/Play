package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /* 用户登录验证 */
    User checkUser(String username, String password);

    /* 注册时验证是否已经存在 */
    User findUserByName(String username);

    /* 注册一个新用户 */
    int userRegister(String username, String password);


    User isAdmin(String adminName, String password);

    int countNumbers();

    List<User> selectAll();
}
