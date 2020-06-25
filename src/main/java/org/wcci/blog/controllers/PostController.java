package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.PostStorage;

@Controller
public class PostController {

    @Autowired
    PostStorage postStorage;

    @GetMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model) {
        model.addAttribute("post", postStorage.findByTitle(title));
        return "post-template";
    }
}


