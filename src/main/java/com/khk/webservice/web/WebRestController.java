package com.khk.webservice.web;

import com.khk.webservice.domain.PostsRepository;
import com.khk.webservice.dto.posts.PostsSaveRequestDto;
import com.khk.webservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
    private PostsService postsService;

    public WebRestController(PostsRepository postsRepository, PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return this.postsService.save(dto);
    }
}
