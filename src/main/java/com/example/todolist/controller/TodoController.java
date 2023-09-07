package com.example.todolist.controller;

import com.example.todolist.dto.CommonResponse;
import com.example.todolist.dto.CreateTodoRequest;
import com.example.todolist.dto.GetTodoList;
import com.example.todolist.dto.UpdateTodoRequest;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<CommonResponse> createTodo(@RequestBody @Valid CreateTodoRequest request) {

        todoService.createTodo(request);

        CommonResponse commonResponse = new CommonResponse("투두 생성이 완료 되었습니다");

        return new ResponseEntity(commonResponse, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CommonResponse> updateTodo(@RequestBody @Valid UpdateTodoRequest request) {

        todoService.updateTodo(request);

        CommonResponse commonResponse = new CommonResponse("투두 수정이 완료 되었습니다");
        return new ResponseEntity(commonResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<CommonResponse> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);

        CommonResponse commonResponse = new CommonResponse("투두 삭제가 완료 되었습니다");
        return new ResponseEntity(commonResponse, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<GetTodoList> getTodoList(@RequestParam int page, @RequestParam int size) {

        GetTodoList todoList = todoService.getTodoList(page, size);

        return new ResponseEntity(todoList, HttpStatus.OK);

    }
}
