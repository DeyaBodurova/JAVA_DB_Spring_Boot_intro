package com.example.bookshop.servises.seed;

import java.io.IOException;

public interface SeedService {

    void seedAuthors() throws IOException;
    void seedBooks() throws IOException;
    void seedCategory() throws IOException;
    default void seedAllData(){
        seedAuthors();
        seedBooks();
        seedCategory();
    }
}
