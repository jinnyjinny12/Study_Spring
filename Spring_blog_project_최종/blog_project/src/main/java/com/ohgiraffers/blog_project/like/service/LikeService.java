package com.ohgiraffers.blog_project.like.service;


import com.ohgiraffers.blog_project.Blog.model.entity.BlogEntity;
import com.ohgiraffers.blog_project.Blog.repository.BlogRepository;
import com.ohgiraffers.blog_project.Blog.service.BlogService;
import com.ohgiraffers.blog_project.like.model.LikeEntity;
import com.ohgiraffers.blog_project.like.repository.LikeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class LikeService {


    private final LikeRepository likeRepository;
    private final BlogRepository blogRepository;

   @Autowired
    public LikeService(LikeRepository likeRepository, BlogRepository blogRepository) {
        this.likeRepository = likeRepository;
        this.blogRepository = blogRepository;
    }

    // 좋아요 갯수 가 올라감
    @Transactional
    // 주어진 게시물ID 에 좋아요를 추가
    public void likePost(Integer id) {

        // 주어진 ID로 블로그 게시물을 찾는다(findByid). 없으면  null  을 반환한다.
        BlogEntity blogEntity = blogRepository.findById(id).orElse(null);

        List<LikeEntity> likeEntities = likeRepository.findByBlog(blogEntity);

            LikeEntity likeEntity;
            if (likeEntities.isEmpty()) {
                // 만약 좋아요 엔티티가 없으면 좋아요 엔터티를 생성하고, 좋아요 수를 1 증가시켜라
                likeEntity = new LikeEntity(blogEntity, 1);

            } else {
                // 좋아요 엔터티가 있으면 숫자만 1을 증가시켜라
                likeEntity = likeEntities.get(0);
                likeEntity.setLikes(likeEntity.getLikes() + 1);
            }
            likeRepository.save(likeEntity);
            // 좋아요 엔터티를 저장한다.
        }



    public int getLikeCountByBlogId(Integer id) {
//        // 블로그가 존재하지 않으면 예외를 발생시킵니다.
//        blogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog not found"));
//
//        List<LikeEntity> likelist = likeRepository.getLikesByLikeid(id);
//        int result = likelist.get(id).getLikes();
//        // 블로그에 대한 모든 좋아요 수를 가져옵니다.
//        System.out.println(result);
//        return result;

        BlogEntity blogEntity = blogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Blog not found"));

        List<LikeEntity> likeEntities = likeRepository.findByBlog(blogEntity);
        if (likeEntities.isEmpty()) {
            return 0;
        }

        // likeEntity 의 첫번째 요소인 0 을
        int result = likeEntities.get(0).getLikes();
        System.out.println(result);
        return result;



   }

}




