package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Post;
import org.wcci.blog.entities.Tag;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.PostRepository;
import org.wcci.blog.storage.repositories.TagRepository;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    TagRepository tagRepo;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category("International Travel");
        Category category2 = new Category("Domestic Travel");
        categoryRepo.save(category1);
        categoryRepo.save(category2);

        Author author1 = new Author("Sarah Greene");
        Author author2 = new Author("Jane Doe");
        Author author3 = new Author("John Doe");

        ArrayList<Author> authors = new ArrayList<Author>();
            authors.add(author1);
            authors.add(author2);

       ArrayList<Author> authors2 = new ArrayList<>();
            authors.add(author2);
            authors.add(author3);

        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);

        Tag tag1 = new Tag("#fun");
        Tag tag2 = new Tag("#natureisbeautiful");
        tagRepo.save(tag1);
        tagRepo.save(tag2);

        Post post1 = new Post("My Trip to Toronto", "Body of blog post", authors, LocalDateTime.parse("April 18, 2019"), category1, tag1, tag2);
        Post post2 = new Post("My Trip to NYC", "Body of blog post 2", authors2, LocalDateTime.parse("February 10, 2020"), category2, tag1);
        postRepo.save(post1);
        postRepo.save(post2);
    }

}
