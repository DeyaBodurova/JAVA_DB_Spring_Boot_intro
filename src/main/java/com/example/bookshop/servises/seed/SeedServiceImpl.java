package com.example.bookshop.servises.seed;

import com.example.bookshop.servises.book.BookService;
import com.example.bookshop.servises.category.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class SeedServiceImpl implements SeedService {
    private final SeedService seedService;
    private final BookService bookService;
    private final CategoryService categoryService;

    public SeedServiceImpl(SeedService seedService, BookService bookService, CategoryService categoryService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedAuthors() {
        RESOUR
    }

    @Override
    public void seedBooks() {

    }

    @Override
    public void seedCategory() {

    }
}
