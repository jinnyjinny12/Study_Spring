package com.ohgiraffers.blog_project.like.model;

public class LikeDTO {

    // 좋아요의 갯수
    private Integer likes;

    public LikeDTO() {
    }

    public LikeDTO(Integer likes) {
        this.likes = likes;
    }


    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "likes=" + likes +
                '}';
    }
}
