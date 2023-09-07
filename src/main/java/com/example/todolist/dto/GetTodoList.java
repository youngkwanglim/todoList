package com.example.todolist.dto;

import com.example.todolist.domain.Todo;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class GetTodoList {

    private Page<Todo> todoList;

    public GetTodoList(Page<Todo> todoList) {
        this.todoList = todoList;
    }
}
