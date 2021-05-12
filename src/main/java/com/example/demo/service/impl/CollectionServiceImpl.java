package com.example.demo.service.impl;


import com.example.demo.entity.Collection;
import com.example.demo.mapper.CollectionMapper;
import com.example.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("collectionServiceImpl")
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;
    @Override
    public boolean likeMovice(String username, Integer mid) {
        return collectionMapper.likeMovice(username, mid) == 1 ? true : false;
    }

    @Override
    public boolean unLikeMovice(String username, Integer mid) {

        return collectionMapper.unLikeMovice(username, mid) == 1 ? true : false;
    }

    @Override
    public boolean findLike(String username, Integer mid) {
        return collectionMapper.findLike(username, mid) == null ? false : true;
    }

    @Override
    public List<Integer> selectCollection(String loginUser) {
        List<Collection> collectionList = collectionMapper.selectCollection(loginUser);
        List<Integer> userIdList = new ArrayList<>();
        for (int i = 0; i < collectionList.size(); i++) {
            userIdList.add(collectionList.get(i).getMid());
        }
        return userIdList;
    }
}
