package com.codestates.todoapp;

import com.codestates.todoapp.dto.TodoRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Todo 생성
     * @param todo
     * @return
     */
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * Todo 수정
     * @param todoId
     * @param requestDto
     * @return
     */
    public Todo updateTodo(Long todoId, TodoRequestDto requestDto) {
        Todo findTodo = findTodo(todoId);

        Optional.ofNullable(requestDto.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));

        Optional.ofNullable(requestDto.getOrder())
                .ifPresent(order -> findTodo.setOrder(order));

        Optional.ofNullable(requestDto.getCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }

    /**
     * Todo 1개 조회
     * @param todoId
     * @return
     */
    public Todo findTodo(Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);

        // null이면 예외 발생
        Todo todo = optionalTodo.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        return todo;
    }

    /**
     * Todo 전체 조회
     * @return
     */
    public List<Todo> findTodos() {
        List<Todo> todos = todoRepository.findAll();

        return todos;
    }

    /**
     * Todo 1개 삭제
     * @param todoId
     */
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    /**
     * Todo 전체 삭제
     */
    public void deleteAll() {
        todoRepository.deleteAll();
    }

}
