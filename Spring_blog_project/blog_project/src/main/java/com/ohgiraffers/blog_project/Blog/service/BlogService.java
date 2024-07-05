package com.ohgiraffers.blog_project.Blog.service;


import com.ohgiraffers.blog_project.Blog.model.dto.BlogDTO;
import com.ohgiraffers.blog_project.Blog.model.entity.BlogEntity;
import com.ohgiraffers.blog_project.Blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void savepost(BlogDTO blogDTO) {
        // 검증로직

        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setTitle(blogDTO.getTitle());
        blogEntity.setContents(blogDTO.getContent());

        // 레파지토리를 이용해서 저장
        blogRepository.save(blogEntity);
    }

    // 저
    // 컨트롤러에서 전달받은 데이터를 레파지토리로 보내는 함수를 만든다.
    // 비즈니스 로직 = 블로그의 CRUD



}
