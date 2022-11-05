package com.example.bookshop.servises.book;

import com.example.bookshop.domain.entities.Book;

import java.util.List;

public interface BookService {
    void seedBooks(List<Book> books);
}
