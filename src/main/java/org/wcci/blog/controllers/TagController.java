package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.TagStorage;

@Controller
public class TagController {

    @Autowired
    TagStorage tagStorage;
    @Autowired
    PostStorage postStorage;

    @GetMapping("hashtags/{hashtagID}")
    public String showReviewsAssociatedWithHashtag(@PathVariable Long hashtagID, Model model) {
        model.addAttribute("tag", tagStorage.findByID(hashtagID));
        return "tag-template";
    }

    @PostMapping("hashtags/add")
    public String addNewHashtag(String hashtagName, String title) {
        Tag tagToAdd = new Tag(hashtagName);
        tagStorage.saveTag(tagToAdd);
        Post post = postStorage.findByTitle(title);
        post.addTag(tagToAdd);
        postStorage.savePost(post);
        return "redirect:/posts/" + title;
    }
}
