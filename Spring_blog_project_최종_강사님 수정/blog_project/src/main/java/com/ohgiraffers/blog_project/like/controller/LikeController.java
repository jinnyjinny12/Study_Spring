package com.ohgiraffers.blog_project.like.controller;

import com.ohgiraffers.blog_project.like.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Controller + ResponseBody 를 결합한 것
// RESTful API : HTTP 를 통해 클라이언트와 서버 간의 데이터를 교환하는 방식
// 반환하는 객체를 자동으로 JSON 형식으로 자동변환하여 HTTP 응답 본문에 포함/

@RestController
public class LikeController {

    private final LikeService likeService;


    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


    @PostMapping("/posts/{id}/like")
    public ResponseEntity<Map<String, Integer>> likePost(@PathVariable("id") Integer id) {

        // 좋아요를 증가시키는 함수
        likeService.likePost(id);

        // 현재 좋아요 수를 불러온다.
        // getLikeCountByBlogId 함수를 통해 좋아요를 불러오고 likeCount 값에 넣어줌
        int likeCount = likeService.getLikeCountByBlogId(id);
        Map<String, Integer> response = new HashMap<>();
       // Map 은 비동기 방식으로 데이터를 전송하기 위해 담아주기 위한 그릇?(컬렉션) 이다
       // response : JSON 형식의 데이터를 담는 Map (이따가 비동기 방식으로 데이터 보내줘야 함)
        //String : 키값(필드명), Integer : 값(좋아요 수)


        response.put("likes", likeCount);
        // 좋아요를 likCount 에 주입

        return ResponseEntity.ok(response);
        // HTTP 응답을 좋아요 수를 포함하는  Map 을 반환.
    }


}
