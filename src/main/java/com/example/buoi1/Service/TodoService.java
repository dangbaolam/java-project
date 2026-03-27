package com.example.buoi1.Service;

import com.example.buoi1.Entity.Todo;

import java.util.List;

public interface TodoService {
 List<Todo> findAll();
 Todo findById(long id);
 Todo add(Todo todo);
 Todo update(Todo todo,long id);
 Todo delete(long id);
}
