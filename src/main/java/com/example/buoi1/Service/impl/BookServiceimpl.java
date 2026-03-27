package com.example.buoi1.Service.impl;

import com.example.buoi1.Entity.Book;
import com.example.buoi1.Service.BookService;
import com.example.buoi1.dto.BookRequest;
import com.example.buoi1.dto.BookResponse;
import com.example.buoi1.exception.CustomResourceNotFoundException;
import com.example.buoi1.repo.Bookrepo;
import jakarta.servlet.GenericServlet;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceimpl implements BookService {
    private final Bookrepo bookrepo;
    private final ModelMapper modelMapper;

    @Override
    public List<BookResponse> findAll() {
        return bookrepo.findAll().stream().map(book -> modelMapper.map(book,BookResponse.class)).toList();
    }

    @Override
    public BookResponse findByID(long id) {
        return bookrepo.findById(id).map(book -> modelMapper.map(book,BookResponse.class))
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found"+id));
    }
    @Override
    public BookResponse add(BookRequest bookRequest) {
        Book book = modelMapper.map(bookRequest,Book.class);
        book.setIsbn(generateIsbn());
        bookrepo.save(book);
        return modelMapper.map(book,BookResponse.class);
    }

    private String generateIsbn() {
        return "ISBN-"+ UUID.randomUUID().toString().substring(0, 13);
    }

    @Override
    public BookResponse update(BookRequest bookRequest, long id) {
        return bookrepo.findById(id).map(b ->{
         if(bookRequest.getTitle() != null) b.setTitle(bookRequest.getTitle());
         if(bookRequest.getAuthor() != null) b.setAuthor(bookRequest.getAuthor());
         if(bookRequest.getPrice()!= null) b.setPrice(bookRequest.getPrice());
         bookrepo.save(b);
         return modelMapper.map(b,BookResponse.class);
        }).orElseThrow(()  -> new CustomResourceNotFoundException("Book not found"));
    }

    @Override
    public void delete(long id) {
        bookrepo.deleteById(id);

    }
}
