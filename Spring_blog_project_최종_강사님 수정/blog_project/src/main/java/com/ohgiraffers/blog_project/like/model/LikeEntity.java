package com.ohgiraffers.blog_project.like.model;


import com.ohgiraffers.blog_project.Blog.model.entity.BlogEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "blog_likes")
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likeid;

    @ManyToOne
    @JoinColumn(name = "id")
    private BlogEntity blog;

    @Column(name = "likes")
    private Integer likes;

    public LikeEntity() {
    }

    public LikeEntity(BlogEntity blog, Integer likes) {
        this.blog = blog;
        this.likes = likes;
    }


    public Integer getLikeid() {
        return likeid;
    }

    public void setLikeid(Integer likeid) {
        this.likeid = likeid;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "LikeEntity{" +
                "likeid=" + likeid +
                ", blog=" + blog +
                ", likes=" + likes +
                '}';
    }
}
