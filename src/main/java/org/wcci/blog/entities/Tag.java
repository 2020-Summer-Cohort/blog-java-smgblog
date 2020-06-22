package org.wcci.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Collection<Post> posts;

    protected Tag(){}

    public Tag(String name, Collection<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
}
