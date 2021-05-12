package com.example.demo.mapper;

import com.example.demo.entity.Movice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoviceMapper {
    /*查出最新的*/
    List<Movice> selectTopFifteen();

    /*共有多少影片*/
    int countMovices();

    /*通过电影id播放对应的电影*/
    Movice movicePlay(Integer mid);

    /*电影播放时提示相同类型的电影*/
    List<Movice> moreMoviceLike(Integer mid, String type);

    List<Movice> searchMovice(Integer page, String name);

    Integer countSearchMovice(String name);

    List<Movice> selectTopfifteenPage(Integer i);

    List<Movice> selectMoviceTypePage(Integer page, String type);

    List<Movice> selectCollectionMovice(Integer i, List<Integer> userIdList);

    List<Movice> selectAll();
}
