package com.example.buoi1.Service;

import com.example.buoi1.Entity.Book;
import com.example.buoi1.dto.BookRequest;
import com.example.buoi1.dto.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();
    BookResponse findByID(long id);
    BookResponse add(BookRequest bookRequest);
    BookResponse update(BookRequest bookRequest,long id);
    void delete(long id);

}
