package com.arthurlage.todoschallenge.dto;

import com.arthurlage.todoschallenge.enumerator.Priority;

import java.sql.Timestamp;
import java.util.UUID;

public record TodoDTO(
        UUID id,
        String name,
        String description,
        boolean isDone,
        Priority priority,
        Timestamp createdAt
) {
}
