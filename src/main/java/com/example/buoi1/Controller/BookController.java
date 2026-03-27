package com.example.buoi1.Controller;

import com.example.buoi1.Entity.Book;
import com.example.buoi1.Service.BookService;
import com.example.buoi1.dto.BookRequest;
import com.example.buoi1.dto.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByID(id));
    }
    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.add(bookRequest));
    }
    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBook(@Valid @RequestBody BookRequest bookRequest, @PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(bookRequest, id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
