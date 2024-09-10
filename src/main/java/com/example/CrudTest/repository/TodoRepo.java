package com.example.CrudTest.repository;

import com.example.CrudTest.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Long> {
}
