package com.ohgiraffers.blog_project.Blog.model.dto;

public class BlogDTO {

    private Integer id;
    private String title;
    private String content;
    private int likeCount;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String title, String content, int likeCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                '}';
    }
}
