package com.arthurlage.todoschallenge.entity;

import com.arthurlage.todoschallenge.dto.CreateTodoRequestDTO;
import com.arthurlage.todoschallenge.enumerator.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String name;
    private String description;
    private boolean isDone = false;
    private Priority priority = Priority.MEDIA;
    @CreatedDate
    private Timestamp createdAt;

    public Todo(String name, String description, boolean isDone, Priority priority) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.priority = priority;
    }

    public Todo(CreateTodoRequestDTO createTodoRequestDTO) {
        this.name = createTodoRequestDTO.name();
        this.description = createTodoRequestDTO.description();
        this.isDone = createTodoRequestDTO.isDone();
        this.priority = createTodoRequestDTO.priority();
    }
}
