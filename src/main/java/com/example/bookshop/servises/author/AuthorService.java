package com.example.bookshop.servises.author;

import com.example.bookshop.domain.entities.Author;

import java.util.List;

public interface AuthorService {
    void seedAuthors(List<Author> authors);
}