package com.arthurlage.todoschallenge.dto;

import com.arthurlage.todoschallenge.enumerator.Priority;

public record CreateTodoRequestDTO(
        String name,
        String description,
        boolean isDone,
        Priority priority
) {
}
