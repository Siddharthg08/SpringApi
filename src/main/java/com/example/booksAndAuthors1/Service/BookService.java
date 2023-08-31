package com.example.booksAndAuthors1.Service;

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
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
//    	System.out.println("Hi");
        return bookRepository.findAll();
    }

    public List<Book> getBooksByGenre(@RequestParam String genre) {
//    	System.out.println("Hey");
        return bookRepository.findByGenre(genre);
    }


    public List<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre, @RequestParam int copies) {
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }

    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}