package com.example.demo.controller;

import com.example.demo.entity.Movice;
import com.example.demo.service.MoviceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    MoviceService moviceService;

    @GetMapping(value = "/user/login")
//    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && ! StringUtils.isEmpty(password)) {
            if (userService.checkUser(username, password)) {
                session.setAttribute("loginUser", username);
                List<Movice> moviceList = moviceService.selectTopFifteen();
                int movices = moviceService.countMovices();
                session.setAttribute("IndexMoviceList",moviceList);
                session.setAttribute("movices",movices);
                return "/index";
            }else {
                map.put("msg","用户名或者密码错误");
                return "/login";
            }
        } else {
            map.put("msg","请正确输入后登录");
            return "/login";
        }

    }
    @PostMapping(value = "/user/register")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("verifyPassword") String verifyPassword,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(verifyPassword)) {
            if (!password.equals(verifyPassword)) {
                map.put("msg","两次密码输入不一致");
                return "/register";
            }
            if (userService.findUserByName(username)) {
                map.put("msg","该用户名已存在");
                return "/register";
            }
            if (userService.userRegister(username,password)) {
//                session.setAttribute("msg","注册成功快登录吧");
//                return "redirect:/login.html";
                return "/login";
            }
        }
        map.put("msg","请完成输入后注册");
        return "/register";

    }

    @RequestMapping(value = "/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/login";
    }
}
