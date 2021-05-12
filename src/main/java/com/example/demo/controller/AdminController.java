package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.entity.Movice;
import com.example.demo.entity.User;
import com.example.demo.service.CommentService;
import com.example.demo.service.MoviceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    MoviceService moviceService;

    @Autowired
    CommentService commentService;

    @GetMapping("/admin_index")
    public String isAdmin(@RequestParam("username") String adminName,
                          @RequestParam("password") String password,
                          HttpSession session) {

        if (userService.isAdmin(adminName, password)) {
            session.setAttribute("loginUser", adminName);
            session.setAttribute("userCounts", userService.countNumbers());
            session.setAttribute("moviceCounts", moviceService.countMovices());
            session.setAttribute("commentCounts", commentService.countComments());
            return "redirect:/admin/admin_index";
        } else {
            return "/admin/admin_login";
        }
    }

    @RequestMapping("/manage_user")
    public String manageUser(HttpSession session) {
        List<User> userList = userService.selectAll();
        session.setAttribute("selectUserList", userList);
        return "/admin/manage_user";
    }

    @RequestMapping("/manage_movice")
    public String manageMovice(HttpSession session) {
        List<Movice> moviceList = moviceService.selectAll();
        session.setAttribute("selectMoviceList", moviceList);
        return "/admin/manage_movice";
    }

    @RequestMapping("/manage_comment")
    public String manageComment(HttpSession session) {
        List<Comment> commentList = commentService.selectAlls();
        session.setAttribute("selectCommentList", commentList);
        return "/admin/manage_comment";
    }

    @RequestMapping("/logout")
    public String adminLogout(HttpSession session) {
        session.invalidate();
        return "/admin/admin_login";
    }


}
