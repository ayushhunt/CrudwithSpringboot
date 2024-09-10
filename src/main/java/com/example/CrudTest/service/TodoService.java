package com.example.CrudTest.service;

import com.example.CrudTest.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    //Create
    Long saveTodo(Todo todo);
    //retrieve
    List<Todo> getTodos();
    //delete
    Todo deleteTodo(Long id);

    //update
    Todo updateTodo(Long id, Todo todo);

    //findbyid
    Optional<Todo> getById(Long id);
}
