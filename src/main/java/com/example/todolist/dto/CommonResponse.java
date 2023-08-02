package com.example.todolist.dto;

import lombok.Getter;

@Getter
public class CommonResponse {

    private String message;

    public CommonResponse(String message) {
        this.message = message;
    }
}

