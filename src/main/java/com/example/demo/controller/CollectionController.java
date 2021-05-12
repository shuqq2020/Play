package com.example.demo.controller;

import com.example.demo.entity.Collection;
import com.example.demo.entity.Movice;
import com.example.demo.service.CollectionService;
import com.example.demo.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @Autowired
    MoviceService moviceService;

    @RequestMapping("/collectionMovice/collectionPage/{collectionPage}")
    public String collectionMovice (@PathVariable("collectionPage") Integer collectionPage,
                                    HttpSession session) {
        String loginUser = (String) session.getAttribute("loginUser");
        List<Integer> MoviceIdList = collectionService.selectCollection(loginUser);
        int size = MoviceIdList.size();
        List<Movice> moviceList =null;
        if(size != 0) {
            moviceList = moviceService.selectCollectionMovice((collectionPage-1) * 15, MoviceIdList);
        }
        session.setAttribute("collectionMoviceList", moviceList);
        session.setAttribute("collectionCount",size);
        session.setAttribute("collectionPage",collectionPage);
        return "/collection";
    }
}
