package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.storage.AuthorStorage;

public class AuthorController {

    @Autowired
    AuthorStorage authorStorage;

    @GetMapping("authors/{authorId}")
    public String showPostsAssociatedWithAuthor(@PathVariable Long authorId, Model model) {
        model.addAttribute("author", authorStorage.findById(authorId));
        return "author-template";
    }
}
