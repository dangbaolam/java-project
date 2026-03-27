package com.example.buoi1.repo;

import com.example.buoi1.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book,Long> {
    Iterable<Long> id(long id);
}
