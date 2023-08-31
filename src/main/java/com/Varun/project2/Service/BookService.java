package com.Varun.project2.Service;

import com.Varun.project2.model.Book;
import com.Varun.project2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/allBooks")
    @CrossOrigin
    public List<Book> getAllBooks(){ return bookRepository.findAll(); }

    @GetMapping("/books/genre")
    @CrossOrigin
    public List<Book> searchByGenre(@RequestParam String genre){
        return bookRepository.findByGenre(genre);
    }

    @GetMapping("/books/genre/copiesAvailable")
    @CrossOrigin
    public List<Book> searchByGenreAndCopiesAvailableGreaterThan(@RequestParam String genre, @RequestParam int copies){
        return bookRepository.findByGenreAndCopiesGreaterThan(genre, copies);
    }

    @PostMapping("/post/book")
    @CrossOrigin
    public Book addBook(@RequestBody @Validated Book Book){return bookRepository.save(Book);}
}
