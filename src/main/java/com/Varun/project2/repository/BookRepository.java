package com.Varun.project2.repository;
import com.Varun.project2.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>{
    public List<Book> findByGenre(String genre);
    public List<Book> findByGenreAndCopiesGreaterThan(String genre, int copiesAvailable);
    public List<Book> findByAuthorId(int id);
}
