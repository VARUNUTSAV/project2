package com.Varun.project2.Service;

import com.Varun.project2.model.Author;
import com.Varun.project2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @PostMapping("/post/author")
    @CrossOrigin
    public Author addAuthor(@RequestBody @Validated Author Author){ return authorRepository.save(Author);}

    @GetMapping("author/by-name-regex")
    @CrossOrigin
    public List<Author> getAuthorsByNameRegex(@RequestParam String nameRegex) {
        return authorRepository.findByNameRegex(nameRegex);
    }
}
