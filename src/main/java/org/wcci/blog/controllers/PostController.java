package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class PostController {

    @Autowired
    PostStorage postStorage;
    @Autowired
    CategoryStorage categoryStorage;

    @GetMapping("posts/{title}")
    public String showSinglePost(@PathVariable String title, Model model) {
        model.addAttribute("post", postStorage.findByTitle(title));
        return "post-template";
    }

    @PostMapping("post/add")
    public String addNewPost(String title, String body, long categoryId) {
        Category postCategory = categoryStorage.findById(categoryId);
        Post postToAdd = new Post(title, body, postCategory);
        postStorage.savePost(postToAdd);
        return "redirect:/categories/" + postCategory.getName();
    }
}


