package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany(mappedBy = "authors")
    private Collection<Post> posts;

    protected Author(){}

    public Author(long id, String name, Collection<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public long getId() {
        return id;
    }
}
