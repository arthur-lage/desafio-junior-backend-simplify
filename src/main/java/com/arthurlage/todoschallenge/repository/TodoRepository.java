package com.arthurlage.todoschallenge.repository;

import com.arthurlage.todoschallenge.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
