package com.example.booksAndAuthors1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksAndAuthors1.models.Author;
import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.AuthorRepository;
import com.example.booksAndAuthors1.repositories.BookRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor( String name){
        Author author = authorRepository.findByName(name);
        String id = author.getId();
        return bookRepository.findByAuthorId(id);
    }

    public List<Author> getAuthorsByNameRegex(String namesRegex) {
        return authorRepository.findByNameRegex(namesRegex);
    }

}