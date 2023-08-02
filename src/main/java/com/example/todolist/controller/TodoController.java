package com.example.todolist.controller;

import com.example.todolist.dto.CommonResponse;
import com.example.todolist.dto.CreateTodoRequest;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<CommonResponse> createTodo(@RequestBody CreateTodoRequest request) {

        todoService.createTodo(request);

        CommonResponse commonResponse = new CommonResponse("투두 생성이 완료 되었습니다");

        return new ResponseEntity(commonResponse, HttpStatus.OK);
    }
}
