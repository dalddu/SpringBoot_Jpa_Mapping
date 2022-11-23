package com.example.Author_exercise.repository;

import com.example.Author_exercise.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
