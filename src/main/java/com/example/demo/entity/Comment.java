package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer id;
    private String username;
    private String content;
    private Date time;
}
