package com.example.bookshop.servises.category;

import com.example.bookshop.domain.entities.Category;
import java.util.List;

public interface CategoryService {
 void seedCategories(List<Category> categories);

 boolean isDataSeeded();

 Set<Category> getRandomCategories();
}