package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comments")
    public String insertComment(String content,
                            HttpSession session){
        String username = (String) session.getAttribute("loginUser");
        commentService.insertComment(username, content, new Date());
        List<Comment> comments = commentService.selectAll();
        session.setAttribute("comments",comments);
        return "/comment";
    }

    @GetMapping("/comment")
    public String selectAll(HttpSession session) {
        List<Comment> comments = commentService.selectAll();
        session.setAttribute("comments",comments);
        return "/comment";
    }
}
