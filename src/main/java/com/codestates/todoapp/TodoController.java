package com.codestates.todoapp;

import com.codestates.todoapp.dto.TodoMapper;
import com.codestates.todoapp.dto.TodoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://todobackend.com")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper mapper;

    // Todo 등록
    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoRequestDto requestDto) {
        Todo createTodo = todoService.createTodo(mapper.todoRequestDtoToTodo(requestDto));

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(createTodo), HttpStatus.CREATED);
    }

    // Todo 1개 조회
    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> todos = todoService.findTodos();
        return new ResponseEntity<>(mapper.todosToTodoResponses(todos), HttpStatus.OK);
    }

    // Todo 전체 조회
    @GetMapping("{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") Long todoId) {
        Todo todo = todoService.findTodo(todoId);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(todo), HttpStatus.OK);
    }

    // Todo 수정
    @PatchMapping("{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") Long todoId, @RequestBody TodoRequestDto requestDto) {
        Todo updateTodo = todoService.updateTodo(todoId, requestDto);

        return new ResponseEntity<>(mapper.todoToTodoResponseDto(updateTodo), HttpStatus.OK);
    }

    // Todo 1개 삭제
    @DeleteMapping("{todo-id}")
    public ResponseEntity deleteTodo(@PathVariable("todo-id") Long todoId) {
        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Todo 전체 삭제
    @DeleteMapping
    public ResponseEntity deleteAll() {
        todoService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
