package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkUser(String username, String password) {
        if (userMapper.checkUser(username, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean findUserByName(String username) {
        if (userMapper.findUserByName(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean userRegister(String username, String password) {
        if (userMapper.userRegister(username,password) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAdmin(String adminName, String password) {
        if (userMapper.isAdmin(adminName, password) != null) {
            return true;
        }
        return false;
    }

    @Override
    public int countNumbers() {
        return userMapper.countNumbers();
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }


}
