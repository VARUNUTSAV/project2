package com.Varun.project2.Service;

import com.Varun.project2.model.author;
import com.Varun.project2.model.book;
import com.Varun.project2.repository.AuthorRepository;
import com.Varun.project2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<book> getBooksByAuthor(String text){
        author a = authorRepository.findByName(text);
        int id = a.getId();

        return bookRepository.findByAuthorId(id);
    }
}
