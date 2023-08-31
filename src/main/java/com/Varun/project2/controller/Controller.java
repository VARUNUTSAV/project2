package com.Varun.project2.controller;

import com.Varun.project2.Service.AuthorBookService;
import com.Varun.project2.Service.AuthorService;
import com.Varun.project2.Service.BookService;
import com.Varun.project2.model.author;
import com.Varun.project2.model.book;
import com.Varun.project2.repository.AuthorRepository;
import com.Varun.project2.repository.BookRepository;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
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
    public List<book> getAllBooks(){ return bookService.getAllBooks(); }

    @GetMapping("/books/genre")
    @CrossOrigin
    public List<book> searchByGenre(@RequestParam String genre){
        return bookService.searchByGenre(genre);
    }

    @GetMapping("/books/genre/copiesAvailable")
    @CrossOrigin
    public List<book> searchByGenreAndCopies(@RequestParam String genre, @RequestParam int copies){
        return bookService.searchByGenreAndCopies(genre, copies);
    }

    @PostMapping("/post/book")
    @CrossOrigin
    public book addBook(@RequestBody @Validated book Book){return bookService.addBook(Book); }

    @PostMapping("/post/author")
    @CrossOrigin
    public author addAuthor(@RequestBody @Validated author Author){ return authorService.addAuthor(Author);}

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
