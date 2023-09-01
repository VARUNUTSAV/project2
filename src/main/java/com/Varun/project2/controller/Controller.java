package com.Varun.project2.controller;

import com.Varun.project2.Service.AuthorBookService;
import com.Varun.project2.Service.AuthorService;
import com.Varun.project2.Service.BookService;
import com.Varun.project2.model.author;
import com.Varun.project2.model.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    AuthorBookService authorBookService;

    @ApiIgnore
    @RequestMapping(value="/api")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allBooks")
    @CrossOrigin
    public List<book> getAllBooks(){ return bookService.getAllBooks(); }

    @GetMapping("/books/genre")
    @CrossOrigin
    public List<book> searchByGenre(@RequestParam String genre){
        return bookService.searchByGenre(genre);
    }

    @GetMapping("/books/genre/copiesAvailable")
    @CrossOrigin
    public List<book> searchByGenreAndCopies(@RequestParam String genre, @RequestParam int copies){
        return bookService.searchByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }

    @PostMapping("/post/book")
    @CrossOrigin
    public book addBook(@RequestBody @Valid book Book){return bookService.addBook(Book); }

    @PostMapping("/post/author")
    @CrossOrigin
    public author addAuthor(@RequestBody author Author){ return authorService.addAuthor(Author);}

    @GetMapping("author/by-name-regex")
    @CrossOrigin
    public List<author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return authorService.getAuthorsByNameRegex(nameRegex);
    }

    @GetMapping("/api/books/by-authors")
    @CrossOrigin
    public List<book> getBooksByAuthor(@RequestParam String author) {
        return authorBookService.getBooksByAuthor(author);
    }

}
