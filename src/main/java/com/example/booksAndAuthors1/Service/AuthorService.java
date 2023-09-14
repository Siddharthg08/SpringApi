package com.example.booksAndAuthors1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booksAndAuthors1.models.Author;
import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.AuthorRepository;
import com.example.booksAndAuthors1.repositories.BookRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor(String name){
//        Author author = authorRepository.findByName(name);
//        String id = author.getId();
//        return bookRepository.findByAuthorId(id);
        String uri = "http://localhost:8080/webflux/books/findByAuthor?authorName="+name;
        return restTemplate.getForObject(uri , List.class);
    }

    public List<Author> getAuthorsByNameRegex(String namesRegex) {
        return authorRepository.findByNameRegex(namesRegex);
    }

}