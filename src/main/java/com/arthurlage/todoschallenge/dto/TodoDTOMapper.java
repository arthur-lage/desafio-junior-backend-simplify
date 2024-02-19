package com.arthurlage.todoschallenge.dto;

import com.arthurlage.todoschallenge.entity.Todo;

import java.util.List;

public class TodoDTOMapper {
    public static List<TodoDTO> toTodoDTO(List<Todo> todos) {
        return todos.stream().map(t -> new TodoDTO(
                        t.getId(),
                        t.getName(),
                        t.getDescription(),
                        t.isDone(),
                        t.getPriority(),
                        t.getCreatedAt()
                ))
                .toList();
    }
}
