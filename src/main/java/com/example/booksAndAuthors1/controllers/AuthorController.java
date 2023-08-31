package com.example.booksAndAuthors1.controllers;

import java.util.List;

import com.example.booksAndAuthors1.Service.AuthorService;
import com.example.booksAndAuthors1.Service.BookService;
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
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String name){
        return authorService.getBooksByAuthor(name);
    }

    @GetMapping("/get")
    public List<Author> getAuthorsByNameRegex(@RequestParam String namesRegex) {
        return authorService.getAuthorsByNameRegex(namesRegex);
    }
    
}