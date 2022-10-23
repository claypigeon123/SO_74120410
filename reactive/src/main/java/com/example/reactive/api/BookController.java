package com.example.reactive.api;

import com.example.reactive.model.Book;
import com.example.reactive.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    // Example of paginated query endpoint
    /*@GetMapping
    public Flux<Book> getAllBooks(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "per-page", defaultValue = "20") Integer perPage,
        @RequestParam(value = "sort-by", required = false) String sortBy,
        @RequestParam(value = "sort-direction", defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        Pageable pageable;

        if (sortBy != null) {
            pageable = PageRequest.of(page, perPage, sortDirection, sortBy);
        } else {
            pageable = PageRequest.of(page, perPage);
        }

        return bookRepository.findAllBy(pageable);
    }*/

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    public Mono<Book> saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping
    public Mono<Void> clearDatabase() {
        return bookRepository.deleteAll();
    }
}
