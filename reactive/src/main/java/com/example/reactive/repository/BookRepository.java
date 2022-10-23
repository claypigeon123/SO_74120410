package com.example.reactive.repository;

import com.example.reactive.model.Book;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveSortingRepository<Book, Long> {
}
