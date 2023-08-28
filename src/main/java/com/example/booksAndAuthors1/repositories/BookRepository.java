package com.example.booksAndAuthors1.repositories;

import java.util.List;

//BookRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.booksAndAuthors1.models.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copies);
    List<Book> findByAuthorId(String authorId);
}

