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

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);

        ArrayList<Author> authors = new ArrayList<Author>();
            authors.add(author1);
            authors.add(author2);

       ArrayList<Author> authors2 = new ArrayList<>();
            authors2.add(author2);
            authors2.add(author3);

        Tag tag1 = new Tag("#fun");
        Tag tag2 = new Tag("#natureisbeautiful");
        tagRepo.save(tag1);
        tagRepo.save(tag2);

        Post post1 = new Post("My Trip to Toronto", "In April of 2019, I spent a weekend in Toronto with some friends. We saw Toronto's tallest building, its oldest castle, and we tried out some local restaurants. We also stopped by Niagara Falls on the drive back home. I hope I get a chance to go back and explore the city some more soon.", authors, LocalDateTime.parse("2019-04-18T12:00:00"), category1, tag1, tag2);
        Post post2 = new Post("My Trip to NYC", "Earlier this year, I spent a weekend in NYC with some friends. It wasn't my first time in NYC, but it was still a great experience. We went to Chinatown, Times Square, Central Park, and of course grabbed a slice of NY pizza. NYC has so much to offer that every trip is a great experience, and I can't wait for my next one.", authors2, LocalDateTime.parse("2020-02-03T11:00:00"), category2, tag1);
        postRepo.save(post1);
        postRepo.save(post2);
    }

}
