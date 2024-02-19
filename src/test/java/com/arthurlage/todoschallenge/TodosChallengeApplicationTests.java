package com.arthurlage.todoschallenge;

import com.arthurlage.todoschallenge.entity.Todo;
import com.arthurlage.todoschallenge.enumerator.Priority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodosChallengeApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateValidTodo() {
        var todo = new Todo("Comprar ovos", "Ir no supermercado X e comprar uma caixa de ovos", true, Priority.BAIXA);

        webTestClient.post()
                .uri("/api/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$.description").isEqualTo(todo.getDescription())
                .jsonPath("$.priority").isEqualTo(todo.getPriority())
                .jsonPath("$.isDone").isEqualTo(todo.isDone())
                .jsonPath("$.createdAt").isEqualTo(todo.getCreatedAt());
    }

    @Test
    void testCreateInvalidTodo() {
        var todo = new Todo("Comprar ovos", "Ir no supermercado X e comprar uma caixa de ovos", true, Priority.BAIXA);

        webTestClient.post()
                .uri("/api/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus()
                .isBadRequest();
    }

}
