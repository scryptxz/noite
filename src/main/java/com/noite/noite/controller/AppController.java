package com.noite.noite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noite.noite.model.Post;
import com.noite.noite.model.PostService;


@Controller
public class AppController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String paginaPrincipal(Model model) {
        model.addAttribute("post", new Post());
        return "index";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @PostMapping("/")
    public String postUser(@ModelAttribute Post post, Model model) {
        PostService cs = context.getBean(PostService.class);
        cs.insertPost(post);
        return "index";
    }
    
}
