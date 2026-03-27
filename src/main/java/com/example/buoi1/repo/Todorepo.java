package com.example.buoi1.repo;

import com.example.buoi1.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Todorepo extends JpaRepository<Todo,Long> {
}
