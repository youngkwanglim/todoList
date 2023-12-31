package com.example.todolist.dto;

import com.example.todolist.enums.CategoryType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
public class CreateTodoRequest {

    @NotBlank(message = "할 일은 꼭 작성해 주셔야 합니다.")
    private String content;

    private Date deadLine;

    private CategoryType category;

}
