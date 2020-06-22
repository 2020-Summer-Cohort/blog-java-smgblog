package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.repositories.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorStorage {

    AuthorRepository authorRepo;

        public AuthorStorage(AuthorRepository authorRepo){
            this.authorRepo = authorRepo;
        }

        public Iterable<Author> findAllAuthors() {
            return authorRepo.findAll();
        }

        public Author findByName(String name) {
            return authorRepo.findByName(name);
        }
    }


