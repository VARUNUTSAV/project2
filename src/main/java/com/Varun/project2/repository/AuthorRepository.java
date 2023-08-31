package com.Varun.project2.repository;
import com.Varun.project2.model.Author;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String>{
    public Author findByName(String text);
    public List<Author> findByNameRegex(String nameRegex);
}
