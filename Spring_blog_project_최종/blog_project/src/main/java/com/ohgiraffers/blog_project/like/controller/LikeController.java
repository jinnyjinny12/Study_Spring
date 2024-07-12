package com.ohgiraffers.blog_project.like.controller;


import com.ohgiraffers.blog_project.like.repository.LikeRepository;
import com.ohgiraffers.blog_project.like.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Controller + ResponseBody 를 결합한 것
// RESTful API : HTTP 를 통해 클라이언트와 서버 간의 데이터를 교환하는 방식
// 반환하는 객체를 자동으로 JSON 형식으로 자동변환하여 HTTP 응답 본문에 포함/

@RestController
public class LikeController {

    private final LikeRepository likeRepository;
    private final LikeService likeService;


    @Autowired
    public LikeController(LikeRepository likeRepository, LikeService likeService) {
        this.likeRepository = likeRepository;
        this.likeService = likeService;
    }


    @PostMapping("/posts/{id}/like")
    public ResponseEntity<Map<String, Integer>> likePost(@PathVariable("id") Integer id) {
        likeService.likePost(id);

        int likeCount = likeService.getLikeCountByBlogId(id);
        Map<String, Integer> response = new HashMap<>();
        // 응답을 보낼 데이터를 저장할 Map 객체러르 생성
        // 검증논리 : 데이터 전송했을 때 맞으면 1, 틀리면 0 그걸 확인하는 로직이 들어가야 함
        // 확인해야 하는 건 서비스에서

        response.put("likes", likeCount);
        // 조회한 조아요 수를 Map 를 맵에 주입한다.

        return ResponseEntity.ok(response);
        // HTTP 응답을 좋아요 수를 포함하는  Map 을 반환.

    }


}
