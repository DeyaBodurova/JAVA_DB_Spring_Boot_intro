package com.example.bookshop.servises.book;

import com.example.bookshop.domain.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks(List<Book> books);

    List<Book> findAllByReleaseDateAfter(LocalDate localDate);



    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
}