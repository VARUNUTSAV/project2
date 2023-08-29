package com.Varun.project2.repository;
import com.Varun.project2.model.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<book, String>{
    public List<book> findByGenre(String genre);
    public List<book> findByGenreAndCopies(String genre, int copiesAvailable);
    public List<book> findByAuthorIdIn(int id);
}
