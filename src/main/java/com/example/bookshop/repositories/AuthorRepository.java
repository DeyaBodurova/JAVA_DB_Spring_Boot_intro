package com.example.bookshop.repositories;

import com.example.bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(Long id);

    Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate date);

    @Query("Select a from Author a order by a.books.size")
    Optional<List<Author>> findAllDistinctOrderByBooks();
}