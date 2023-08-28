package com.example.booksAndAuthors1.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.booksAndAuthors1.models.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByNameRegex(String regex);
    Author findByName(String name);
}