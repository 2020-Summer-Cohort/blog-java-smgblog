package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany
    private Collection<Post> posts;

    protected Category(){}

    public Category(String name, Collection<Post> posts) {
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
