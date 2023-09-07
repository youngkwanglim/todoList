package com.example.todolist.dto;

import com.example.todolist.enums.CategoryType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
public class UpdateTodoRequest {

    private Long todoId;

    @NotBlank(message = "수정할 할 일은 있어야 합니다.")
    private String content;

    private Date deadLine;

    private CategoryType category;
}
