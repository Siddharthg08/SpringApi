package com.example.booksAndAuthors1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.example.booksAndAuthors1.models.Author;
import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.AuthorRepository;
import com.example.booksAndAuthors1.repositories.BookRepository;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.List;
import javax.validation.Valid;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<Book> getAllBooks() {
//        System.out.println("wowwoww");
//        Flux<Book> f = restTemplate.getForEntity("http://localhost:8080/webflux/books/", Flux.class);
//        System.out.println("Hello\n");
//        return f.collectList().block();
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