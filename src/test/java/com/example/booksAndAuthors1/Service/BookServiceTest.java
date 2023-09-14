package com.example.booksAndAuthors1.Service;

import com.example.booksAndAuthors1.models.Book;
import com.example.booksAndAuthors1.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    @Test
    void getAllBooks() {
        when(bookRepository.findAll()).thenReturn(Stream.of(new Book("4",50, "4","fiction"), new Book("5",60, "5","Horror")).collect(Collectors.toList()));
        assertEquals(2,bookService.getAllBooks().size());
    }

    @Test
    void getBooksByGenre() {
    }

    @Test
    void getBooksByGenreAndCopiesAvailable() {
    }

    @Test
    void saveBook() {
    }
}