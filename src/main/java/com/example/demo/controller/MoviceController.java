package com.example.demo.controller;


import com.example.demo.entity.Movice;
import com.example.demo.service.MoviceService;
import com.example.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MoviceController {
    @Autowired
    MoviceService moviceService;
    @Autowired
    CollectionService collectionService;

    @GetMapping("/movicePlay/id/{mid}/type/{type}")
    public String movicePlay(@PathVariable("mid") Integer mid,
                             @PathVariable("type") String type,
                             Map<String,Object> map, HttpSession session) {
        Movice movice = moviceService.movicePlay(mid);
        List<Movice> moviceLikeList = moviceService.moreMoviceLike(mid, type);
        String  username = (String) session.getAttribute("loginUser");
//        System.out.println("username: " + username);
        boolean flag = collectionService.findLike(username, mid);
//        System.out.println("flag:" + flag);
        session.setAttribute("movice", movice);
        session.setAttribute("moviceLikeList", moviceLikeList);
        session.setAttribute("flag", flag);
        return "movicePlay";
    }

    @PostMapping("/movicePlay/likeMovice")
    public String likeMovice(HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        Movice movice = (Movice) session.getAttribute("movice");
//        System.out.println("mid:" + movice.getMid());
        boolean flag = collectionService.findLike(username, movice.getMid());
        if (flag) {
            collectionService.unLikeMovice(username, movice.getMid());
        } else {
            collectionService.likeMovice(username, movice.getMid());
        }
        session.setAttribute("flag",flag);
        return "/movicePlay";

    }

    @PostMapping("/movicePlay/searchMovice")
    public String searchMovice(@RequestParam String name,
                               @RequestParam Integer page,
                               HttpSession session, Map<String, Object> map) {
//        System.out.println(name);
//        System.out.println(page);
        List<Movice> searchMoviceList = moviceService.searchMovice((page-1) * 5, name);
        int countSearchMovice = moviceService.countSearchMovice(name);
//        System.out.println(searchMoviceList);
        session.setAttribute("SearchMoviceList", searchMoviceList);
        session.setAttribute("searchName", name);
        session.setAttribute("countSearchMovice", countSearchMovice);
        session.setAttribute("page", page);
        return "/search";
    }

    @GetMapping("/search/page/{page}/name/{name}")
    public String goPageMovice(@PathVariable ("page") Integer page,
                               @PathVariable ("name") String name,
                               HttpSession session) {
        List<Movice> searchMovice = moviceService.searchMovice((page-1) * 5, name);
        session.setAttribute("SearchMoviceList", searchMovice);
        session.setAttribute("page", page);
//        session.setAttribute("background-color","#fff");
//        session.setAttribute("background-color","#fff");
//        System.out.println(searchMovice);
        return "redirect:/search";
    }

    @RequestMapping("/sort")
    public String sortMovice(HttpSession session){
        int countSearchMovice = moviceService.countMovices();
        List<Movice> searchMoviceList = moviceService.selectTopFifteen();
        session.setAttribute("moviceList", searchMoviceList);
        session.setAttribute("countSearchMovice", countSearchMovice);
        session.setAttribute("page", 1);
        return "/sort";
    }


    @RequestMapping("/sort/page/{page}")
    public String sortMovicePage(@PathVariable ("page") Integer page, HttpSession session){
        System.out.println("page:"+page);
        List<Movice> searchMoviceList = moviceService.selectTopFifteenPage((page - 1) * 15);
        session.setAttribute("moviceList", searchMoviceList);
        System.out.println(searchMoviceList);
        session.setAttribute("page", page);
        session.setAttribute("type", null);
        return "/sort";
    }


    @RequestMapping("/sort/page/{page}/type/{type}")
    public String moviceSortPage(@PathVariable("page") Integer page, @PathVariable("type") String type, HttpSession session) {
        List<Movice> searchMoviceList =moviceService.selectMoviceTypePage((page - 1) * 15,type);
        session.setAttribute("moviceList", searchMoviceList);
        session.setAttribute("page", page);
        session.setAttribute("type", type);
        return "/sort";
    }


}
