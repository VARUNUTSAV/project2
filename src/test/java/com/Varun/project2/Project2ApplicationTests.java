package com.Varun.project2;

import com.Varun.project2.Service.AuthorBookService;
import com.Varun.project2.Service.AuthorService;
import com.Varun.project2.Service.BookService;
import com.Varun.project2.model.Address;
import com.Varun.project2.model.author;
import com.Varun.project2.model.book;
import com.Varun.project2.repository.AuthorRepository;
import com.Varun.project2.repository.BookRepository;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Project2ApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorBookService authorBookService;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    public void getAllBooksTest(){
        when(bookRepository.findAll()).thenReturn(Stream.of
                (new book(1, 3, 101, "Fiction"), new book(2, 4, 102, "Thriller")).collect(Collectors.toList()));
        assertEquals(2, bookService.getAllBooks().size());
    }

    @Test
    public void searchByGenreTest(){
        String genre = "Mystery";
        when(bookRepository.findByGenre(genre)).thenReturn(Stream.of
                (new book(2, 4, 102, "Mystery")).collect(Collectors.toList()));
        assertEquals(1, bookService.searchByGenre(genre).size());
    }

    @Test
    public void searchByGenreAndCopiesTest(){
        String genre = "Fiction";
        int copies = 2;
        when(bookRepository.findByGenreAndCopiesGreaterThan(genre, copies)).thenReturn(Stream.of
                (new book(3, 4, 103, "Fiction")).collect(Collectors.toList()));
        assertEquals(1, bookService.searchByGenreAndCopiesAvailableGreaterThan(genre, copies).size());
    }

    @Test
    public void addBookTest(){
        book Book = new book(4, 6, 102, "Thriller");
        when(bookRepository.save(Book)).thenReturn(Book);
        assertEquals(Book, bookService.addBook(Book));
    }

    @Test
    public void addAuthorTest(){
        author Author = new author(102, "John Wick", new Address("12", "pune", "maharashtra"));
        when(authorRepository.save(Author)).thenReturn(Author);
        assertEquals(Author, authorService.addAuthor(Author));
    }

    @Test
    public void getAuthorsByNameRegexTest(){
        String name = "Joh";
        when(authorRepository.findByNameRegex(name)).thenReturn(Stream.of
                (new author(102, "John Wick", new Address("12", "pune", "maharashtra"))).collect(Collectors.toList()));

        assertEquals(1, authorService.getAuthorsByNameRegex(name).size());
    }

    @Test
    public void getBooksByAuthorTest(){
        String authorName = "Tim";
        author Author = new author(105, "Tim", new Address("34", "pune", "maharashtra"));
        when(authorRepository.findByName(authorName)).thenReturn(Author);
        int id = Author.getId();
        when(bookRepository.findByAuthorId(id)).thenReturn(Stream.of(new book(2, 5, 105, "comic")).collect(Collectors.toList()));
        assertEquals(2, authorBookService.getBooksByAuthor(authorName).get(0).getId());

    }
}
