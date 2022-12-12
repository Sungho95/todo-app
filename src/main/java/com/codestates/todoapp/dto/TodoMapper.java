package com.codestates.todoapp.dto;

import com.codestates.todoapp.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    public Todo todoPostToTodo(TodoPostDto todoPostDto) {
        if (todoPostDto == null) {
            return null;
        }

        Todo todo = Todo.builder()
                .title(todoPostDto.getTitle())
                .order(todoPostDto.getOrder())
                .completed(todoPostDto.getCompleted())
                .build();

        return todo;

    }

    public Todo todoPatchToTodo(TodoPostDto todoPostDto) {
        if (todoPostDto == null) {
            return null;
        }

        Todo todo = Todo.builder()
                .title(todoPostDto.getTitle())
                .order(todoPostDto.getOrder())
                .completed(todoPostDto.getCompleted())
                .build();

        return todo;
    }

    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        if (todo == null) {
            return null;
        }

        Long id = 0L;
        String title = null;
        Long order = 0L;
        Boolean completed = null;

        id = todo.getId();
        title = todo.getTitle();
        order = todo.getOrder();
        completed = todo.getCompleted();

        TodoResponseDto todoResponseDto = TodoResponseDto
                .builder()
                .id(id)
                .title(title)
                .order(order)
                .completed(completed)
                .build();

        return todoResponseDto;

    }

    public List<TodoResponseDto> todosToTodoResponses(List<Todo> todos) {
        if (todos == null) {
            return null;
        }

        List<TodoResponseDto> list = new ArrayList<>(todos.size());
        for (Todo todo : todos) {
            list.add(todoToTodoResponseDto(todo));
        }

        return list;
    }
}
