package com.example.demo.service;

import com.example.demo.entity.Movice;

import java.util.List;

public interface MoviceService {
    List<Movice> selectTopFifteen();

    int countMovices();

    Movice movicePlay(Integer mid);


    List<Movice> moreMoviceLike(Integer mid, String type);

    List<Movice> searchMovice(Integer page, String name);

    int countSearchMovice(String name);

    List<Movice> selectTopFifteenPage(Integer i);

    List<Movice> selectMoviceTypePage(Integer i, String type);

    List<Movice> selectCollectionMovice(Integer i, List<Integer> userIdList);

    List<Movice> selectAll();
}
