package com.Varun.project2.Service;

import com.Varun.project2.model.author;
import com.Varun.project2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public author addAuthor(@RequestBody author Author){ return authorRepository.save(Author);}


    public List<author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return authorRepository.findByNameRegex(nameRegex);
    }
}
