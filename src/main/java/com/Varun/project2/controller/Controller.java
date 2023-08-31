package com.Varun.project2.controller;

import com.Varun.project2.Service.AuthorBookService;
import com.Varun.project2.Service.AuthorService;
import com.Varun.project2.Service.BookService;
import com.Varun.project2.model.Author;
import com.Varun.project2.model.Book;
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
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allBooks")
    @CrossOrigin
    public List<Book> getAllBooks(){ return bookService.getAllBooks(); }

    @GetMapping("/books/genre")
    @CrossOrigin
    public List<Book> searchByGenre(@RequestParam String genre){
        return bookService.searchByGenre(genre);
    }

    @GetMapping("/books/genre/copiesAvailable")
    @CrossOrigin
    public List<Book> searchByGenreAndCopies(@RequestParam String genre, @RequestParam int copies){
        return bookService.searchByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }

    @PostMapping("/post/book")
    @CrossOrigin
    public Book addBook(@RequestBody @Valid Book Book){return bookService.addBook(Book); }

    @PostMapping("/post/author")
    @CrossOrigin
    public Author addAuthor(@RequestBody @Valid Author Author){ return authorService.addAuthor(Author);}

    @GetMapping("author/by-name-regex")
    @CrossOrigin
    public List<Author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return authorService.getAuthorsByNameRegex(nameRegex);
    }

    @GetMapping("/api/books/by-authors")
    @CrossOrigin
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return authorBookService.getBooksByAuthor(author);
    }

}
