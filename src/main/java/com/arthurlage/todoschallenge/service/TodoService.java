package com.arthurlage.todoschallenge.service;

import com.arthurlage.todoschallenge.dto.CreateTodoRequestDTO;
import com.arthurlage.todoschallenge.dto.TodoDTO;
import com.arthurlage.todoschallenge.dto.TodoDTOMapper;
import com.arthurlage.todoschallenge.entity.Todo;
import com.arthurlage.todoschallenge.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> getTodos () {
        return TodoDTOMapper.toTodoDTO(this.todoRepository.findAll());
    }

    public List<TodoDTO> createTodo (CreateTodoRequestDTO createTodoRequest) {
        Todo newTodo = new Todo(createTodoRequest);
        this.todoRepository.save(newTodo);
        return this.getTodos();
    }
}
