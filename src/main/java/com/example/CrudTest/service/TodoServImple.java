package com.example.CrudTest.service;

import com.example.CrudTest.entity.Todo;
import com.example.CrudTest.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServImple implements TodoService {

    @Autowired
    private TodoRepo todoRepo;


    @Override
    public Long saveTodo(Todo todo) {
        Todo _todo = todoRepo.save(todo);
        return _todo.getId();
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    @Override
    public Todo deleteTodo(Long id) {
        Optional<Todo> _todo = todoRepo.findById(id);

        if(_todo.isPresent()){
            todoRepo.deleteById(id);
        }
        return _todo.get();
    }

    @Override
    public Optional<Todo> getById(Long id){
        Optional<Todo> todo1 = todoRepo.findById(id);
        return todo1;
    }
    @Override
    public Todo updateTodo(Long id, Todo newtodo) {
        Optional<Todo> _todo = todoRepo.findById(id);
        Todo todo = _todo.get();
        if(_todo.get() != null){
            todo.setTitle(newtodo.getTitle());
            todo.setDescription(newtodo.getDescription());
            todo.setDone(newtodo.isDone());
        }
        todoRepo.save(todo);
        return todo;
    }
}
