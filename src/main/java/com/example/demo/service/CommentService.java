package com.example.demo.service;


import com.example.demo.entity.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {

    List<Comment> selectAll();

    void insertComment(String username, String content, Date date);

    int countComments();

    List<Comment> selectAlls();
}
