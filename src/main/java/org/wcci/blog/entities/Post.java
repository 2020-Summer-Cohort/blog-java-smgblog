package org.wcci.blog.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Lob
    private String body;
    @ManyToMany
    private Collection<Author> authors;
    private LocalDateTime publishDate;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Tag> tags;

    protected Post(){}

    public Post(String title, String body, Collection<Author> authors, LocalDateTime publishDate, Category category, Collection<Tag> tags) {
        this.title = title;
        this.body = body;
        this.authors = authors;
        this.publishDate = publishDate;
        this.category = category;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getId() {
        return id;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
}