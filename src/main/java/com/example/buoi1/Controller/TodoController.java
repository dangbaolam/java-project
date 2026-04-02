package com.example.buoi1.Controller;

import com.example.buoi1.Entity.Todo;
import com.example.buoi1.Service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @GetMapping
    public ResponseEntity <List<Todo>> getallTodos(){
        List<Todo> todos = todoService.findAll();
        return new  ResponseEntity<>(todos, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable long id){
      Todo todo =  todoService.findById(id);
      return new ResponseEntity<>(todo, HttpStatus.OK);//200
    }
    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo) {
       Todo saveTodo =todoService.add(todo);
       return new ResponseEntity<>(saveTodo, HttpStatus.CREATED);//201
        }
   @PutMapping("{id}")
    public ResponseEntity<Todo> update( @PathVariable long id ,@Valid @RequestBody Todo todo){
        Todo updateTodo = todoService.update(todo,id);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);//200
   }
   @DeleteMapping("{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable long id){
        Todo deleteTodo=todoService.delete(id);
        return new ResponseEntity<>(deleteTodo, HttpStatus.OK);//200
    }

}
