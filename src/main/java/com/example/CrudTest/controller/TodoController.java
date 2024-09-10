package com.example.CrudTest.controller;

import com.example.CrudTest.entity.Todo;
import com.example.CrudTest.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/saveTodo")
    public long saveTodo(@Valid @RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @GetMapping("/alltodos")
    public ResponseEntity<List<Todo>> getAll(){
        List<Todo> t = todoService.getTodos();
        return new ResponseEntity<List<Todo>>(t, HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id){
        Optional<Todo> todo = todoService.getById(id);
        if(todo.isPresent()){
            return new ResponseEntity<Todo>(todo.get(),HttpStatus.OK);
        }else {
            throw new NoSuchElementException("record not found");
        }
    }
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable  Long id,@RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("/todos/del/{id}")
    public Todo deleteTodo(@PathVariable  Long id){
        return todoService.deleteTodo(id);
    }
}
