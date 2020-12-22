package com.khk.webservice.web;

import com.khk.webservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private PostsService postsService;
    public WebController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
