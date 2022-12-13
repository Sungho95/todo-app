package com.codestates.todoapp.dto;

import com.codestates.todoapp.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoMapper {
    public Todo todoRequestDtoToTodo(TodoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        if (ObjectUtils.isEmpty(requestDto.getTitle())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (ObjectUtils.isEmpty(requestDto.getOrder())) {
            requestDto.setOrder(0L);
        }

        if (ObjectUtils.isEmpty(requestDto.getCompleted())) {
            requestDto.setCompleted(false);
        }

        Todo todo = Todo.builder()
                .title(requestDto.getTitle())
                .order(requestDto.getOrder())
                .completed(requestDto.getCompleted())
                .build();

        return todo;

    }

    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        if (todo == null) {
            return null;
        }

        Long id = todo.getId();
        String title = todo.getTitle();
        Long order = todo.getOrder();
        Boolean completed = todo.getCompleted();

        TodoResponseDto todoResponseDto = TodoResponseDto
                .builder()
                .id(id)
                .title(title)
                .order(order)
                .completed(completed)
                .url("http://localhost:8080/"+id)
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
