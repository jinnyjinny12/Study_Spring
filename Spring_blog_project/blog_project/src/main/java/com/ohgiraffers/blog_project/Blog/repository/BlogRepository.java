package com.ohgiraffers.blog_project.Blog.repository;

// 이거를 interface 로 만들어야  CRUD 를 쉽게 만들 수 있다.


import com.ohgiraffers.blog_project.Blog.model.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
}
