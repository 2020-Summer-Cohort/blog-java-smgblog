package org.wcci.blog.storage.repositories;
import org.wcci.blog.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}
