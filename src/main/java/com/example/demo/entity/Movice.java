package com.example.demo.entity;

import lombok.Data;

@Data
public class Movice {

    private Integer mid;
    /*电影名*/
    private String moviceName;
    /*电影资源路径*/
    private String url;
    /*导演*/
    private String director;
    /*主演*/
    private String star;
    /*地区*/
    private String area;
    /*年份*/
    private String year;
    /*清晰度*/
    private String definition;
    /*介绍*/
    private String introduction;
    /*类型*/
    private String type;
}
