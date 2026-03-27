package com.example.buoi1.Service.impl;

import com.example.buoi1.Entity.Todo;
import com.example.buoi1.Service.TodoService;
import com.example.buoi1.exception.CustomResourceNotFoundException;
import com.example.buoi1.repo.Todorepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final Todorepo  todorepo;

    @Override
    public List<Todo> findAll() {
        return todorepo.findAll();
    }

    @Override
    public Todo findById(long id) {
        return todorepo.findById(id).orElseThrow(()-> new CustomResourceNotFoundException("todo khong tim thay id: "+id));
    }

    @Override
    public Todo add(Todo todo) {
        if (todo.getCompleted() == null) todo.setCompleted(false);
        return todorepo.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id) {
        return todorepo.findById(id).map(exitsting ->{
            if(todo.getTitle() != null) exitsting.setTitle(todo.getTitle());
            if(todo.getDescription() != null) exitsting.setDescription(todo.getDescription());
            if (todo.getCompleted() != null) exitsting.setCompleted(todo.getCompleted());
            return todorepo.save(exitsting);
        })
                .orElse(null);
    }

    @Override
    public Todo delete(long id) {
       Todo delete = findById(id);
       if(delete != null){
           todorepo.deleteById(id);
       }
        return delete;
    }
}
