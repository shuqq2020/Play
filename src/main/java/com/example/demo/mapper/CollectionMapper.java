package com.example.demo.mapper;

import com.example.demo.entity.Collection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {
    /*用户将电影加入收藏*/
    int likeMovice(String username, Integer mid);

    /*用户将电影取消收藏*/
    int unLikeMovice(String username, Integer mid);

    /*电影播放时判断是否收藏*/
    Collection findLike(String username, Integer mid);

    List<Collection> selectCollection(String loginUser);
}
