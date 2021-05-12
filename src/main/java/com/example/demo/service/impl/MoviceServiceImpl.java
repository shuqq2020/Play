package com.example.demo.service.impl;

import com.example.demo.entity.Movice;
import com.example.demo.mapper.MoviceMapper;
import com.example.demo.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MoviceServiceImpl")
public class MoviceServiceImpl implements MoviceService {

    @Autowired
    MoviceMapper moviceMapper;

    @Override
    public List<Movice> selectTopFifteen() {
        return moviceMapper.selectTopFifteen();
    }

    @Override
    public int countMovices() {
        return moviceMapper.countMovices();
    }

    @Override
    public Movice movicePlay(Integer mid) {
        return moviceMapper.movicePlay(mid);
    }

    @Override
    public List<Movice> moreMoviceLike(Integer mid, String type) {
        return moviceMapper.moreMoviceLike(mid, type);
    }

    @Override
    public List<Movice> searchMovice(Integer page, String name) {
        return moviceMapper.searchMovice(page, name);
    }

    @Override
    public int countSearchMovice(String name) {
        Integer integer = moviceMapper.countSearchMovice(name);
        return integer == null ? 0 : integer;
    }

    @Override
    public List<Movice> selectTopFifteenPage(Integer i) {
        return moviceMapper.selectTopfifteenPage(i);
    }

    @Override
    public List<Movice> selectMoviceTypePage(Integer page, String type) {
        return moviceMapper.selectMoviceTypePage(page, type);
    }

    @Override
    public List<Movice> selectCollectionMovice(Integer i, List<Integer> userIdList) {
        return moviceMapper.selectCollectionMovice(i, userIdList);
    }

    @Override
    public List<Movice> selectAll() {
        return moviceMapper.selectAll();
    }
}
