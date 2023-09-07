package com.example.todolist.domain;


import com.example.todolist.dto.CreateTodoRequest;
import com.example.todolist.dto.UpdateTodoRequest;
import com.example.todolist.enums.CategoryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String contents;

    private Date deadLine;

    private CategoryType category;

    public Todo(CreateTodoRequest request) {
        this.contents = request.getContent();
        this.deadLine = request.getDeadLine();
        this.category= request.getCategory();
    }

    public void updateTodo(UpdateTodoRequest request) {

        contents = request.getContent();
        deadLine = request.getDeadLine();
        category = request.getCategory();
    }
}



