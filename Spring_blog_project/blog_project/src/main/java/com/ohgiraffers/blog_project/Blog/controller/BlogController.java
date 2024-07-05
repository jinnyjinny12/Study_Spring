package com.ohgiraffers.blog_project.Blog.controller;

import com.ohgiraffers.blog_project.Blog.model.dto.BlogDTO;
import com.ohgiraffers.blog_project.Blog.repository.BlogRepository;
import com.ohgiraffers.blog_project.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    // 글을 등록하는 화면 = 글을 쓰는 화면
    // 글을 쓰는 화면인데 게시글을 보여주는 코드를 가져옴
    //
    @GetMapping("/posts")
    public void posts() {
      // 게시글의 제목, 내용을 입력하는 화면을 가져와야 한다
        // 모델엔 뷰가 필요없으니 등록하면  등록하는 html만 가져오면 된다.
    }

//    // 등록한 글을 보낸다 데이터에
    @PostMapping("/posts")
    public ModelAndView posts(@ModelAttribute BlogDTO blogDTO, ModelAndView mv) {
        blogService.savepost(blogDTO);
        mv.setViewName("posts");
        return mv;
    }

    // 1. 사용자가 입력한 데이터를 받는다. html
    // 2. 사용자가 입력한 데이터를 모델에 담는다?
    // 3. 그걸 서비스로 보낸다 ->

//    전체 조회할 화면을 가져온다
//    @GetMapping("/list")


//    id에 맞는 상세조회할 화면을 가져온다
//    @GetMapping("/posts/{id}")
//
//
//    // 수정할 화면을 가져온다
//    @GetMapping("/modify/{id}")
//
//    //수정한 화면을 보낸다
//    @PostMapping("/modify/{id}")

//
//    // 버튼 누르면 해당하는 id 가 삭제된다
//    @PostMapping("/delete/{id}")
//



}
