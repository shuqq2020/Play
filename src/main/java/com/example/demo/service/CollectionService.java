package com.example.demo.service;

import com.example.demo.entity.Collection;

import java.util.List;

public interface CollectionService {

    boolean likeMovice(String username, Integer mid);

    boolean unLikeMovice(String username, Integer mid);

    boolean findLike(String username, Integer mid);

    List<Integer> selectCollection(String loginUser);
}
