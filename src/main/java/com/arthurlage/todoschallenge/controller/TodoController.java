package com.arthurlage.todoschallenge.controller;

import com.arthurlage.todoschallenge.dto.CreateTodoRequestDTO;
import com.arthurlage.todoschallenge.service.TodoService;
import com.arthurlage.todoschallenge.dto.TodoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController (TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getTodos () {
        return ResponseEntity.ok(this.todoService.getTodos());
    }

    @PostMapping
    public ResponseEntity<List<TodoDTO>> createTodo (@RequestBody @Valid CreateTodoRequestDTO createTodoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.todoService.createTodo(createTodoRequest));
    }
}
