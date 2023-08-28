package com.example.booksAndAuthors1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.booksAndAuthors1.models.Author;
import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.AuthorRepository;
import com.example.booksAndAuthors1.repositories.BookRepository;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String name){
    	System.out.println("Hi");
    	Author author = authorRepository.findByName(name);
    	String id = author.getId();
    	return bookRepository.findByAuthorId(id);
    }

    @GetMapping("/get")
    public List<Author> getAuthorsByNameRegex(@RequestParam String namesRegex) {
        return authorRepository.findByNameRegex(namesRegex);
    }
    
}