package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectAll();

    void insertComment(String username, String content, Date date);

    int countComments();

    List<Comment> selectAlls();
}
