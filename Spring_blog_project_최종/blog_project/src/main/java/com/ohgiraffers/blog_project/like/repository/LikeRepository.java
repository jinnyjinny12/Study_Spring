package com.ohgiraffers.blog_project.like.repository;

import com.ohgiraffers.blog_project.Blog.model.entity.BlogEntity;
import com.ohgiraffers.blog_project.like.model.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// likeEntity 에 대한 인터페이스를 JPA 를 사용해서 작성한다.
// Spring Data JPA를 사용하여 LikeEntity에 대한 데이터 접근 레이어를 정의
// <LikeEntity, Integer>를 붙여 JPA가 어떤 엔터티리를 처리하고 그 엔티티 타입이 무엇인지 명시할 수 있다.

@Repository
public interface LikeRepository extends JpaRepository <LikeEntity, Integer> {
    // findByBlog 메서드는 BlogEntitiy 를 받아서 해당 포스트와 연결된  likeEntity 를 반환
    List<LikeEntity> findByBlog(BlogEntity blog);

    //블로그 포스트의  id 를 받아서 해당 포스트의 좋아요 갯수를 반환
    //좋아요 갯수: 포스트 ID 와 맵핑되어 있는 likes 의 갯수
    int countByBlog_Id(Integer id);//    // 좋아요 id를 기준으로 엔터티들을 검색
    int countByLikes(Integer id);
    List<LikeEntity> getLikesByLikeid(Integer id);



}
