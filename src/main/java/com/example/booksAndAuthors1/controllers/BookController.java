package com.example.booksAndAuthors1.controllers;

import com.example.booksAndAuthors1.Service.AuthorService;
import com.example.booksAndAuthors1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.booksAndAuthors1.models.Author;
import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.AuthorRepository;
import com.example.booksAndAuthors1.repositories.BookRepository;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
//    	System.out.println("Hi");
        return bookService.getAllBooks();
    }

    @GetMapping("/genre")
    public List<Book> getBooksByGenre(@RequestParam String genre) {
//    	System.out.println("Hey");
        return bookService.getBooksByGenre(genre);
    }

    
    @GetMapping("/genreAndCopies")
    public List<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre, @RequestParam int copies) {
        return bookService.getBooksByGenreAndCopiesAvailable(genre, copies);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }
}