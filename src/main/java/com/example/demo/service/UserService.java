package com.example.demo.service;


import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    boolean checkUser(String username,String password);

    boolean findUserByName(String username);

    boolean userRegister(String username,String password);

    boolean isAdmin(String adminName, String password);

    int countNumbers();

    List<User> selectAll();
}
