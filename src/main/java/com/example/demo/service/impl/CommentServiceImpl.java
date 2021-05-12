package com.example.demo.service.impl;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @Override
    public void insertComment(String username, String content, Date date) {
        commentMapper.insertComment(username, content, date);
    }

    @Override
    public int countComments() {
        return commentMapper.countComments();
    }

    @Override
    public List<Comment> selectAlls() {
        return commentMapper.selectAlls();
    }
}
