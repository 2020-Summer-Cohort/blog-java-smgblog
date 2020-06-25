package org.wcci.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.wcci.blog.storage.CategoryStorage;


@Controller
public class CategoryController {

    @Autowired
    CategoryStorage categoryStorage;


    @GetMapping("categories")
    public String showAllCategories(Model model) {
        model.addAttribute("categoryNames", categoryStorage.findAllCategories());
        return "category-template";
    }

    @GetMapping("/categories/{categoryName}")
    public String showPostsAssociatedWithCategory(Model model, @PathVariable String categoryName) {
        model.addAttribute("category", categoryStorage.findByName(categoryName));
        return "subcategory-template";
    }
}
