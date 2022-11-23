package com.example.Author_exercise.repository;

import com.example.Author_exercise.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}