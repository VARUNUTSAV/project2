package com.Varun.project2.Service;

import com.Varun.project2.model.book;
import com.Varun.project2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<book> getAllBooks(){ return bookRepository.findAll(); }


    public List<book> searchByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }


    public List<book> searchByGenreAndCopiesAvailableGreaterThan(String genre, int copies){
        return bookRepository.findByGenreAndCopiesGreaterThan(genre, copies);
    }

    public book addBook(book Book){return bookRepository.save(Book);}
}
