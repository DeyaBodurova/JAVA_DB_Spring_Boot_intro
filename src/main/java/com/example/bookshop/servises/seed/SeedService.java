package com.example.bookshop.servises.seed;

public interface SeedService {

    void seedAuthors();
    void seedBooks();
    void seedCategory();
    default void seedAllData(){
        seedAuthors();
        seedBooks();
        seedCategory();
    }
}
