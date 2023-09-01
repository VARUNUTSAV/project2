package com.Varun.project2.repository;
import com.Varun.project2.model.author;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<author, String>{
    public author findByName(String text);
    public List<author> findByNameRegex(String nameRegex);
}
