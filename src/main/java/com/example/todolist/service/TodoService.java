package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.dto.CreateTodoRequest;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodo(CreateTodoRequest request) {

        Todo todo = new Todo(request.getContent());

        todoRepository.save(todo);

    }
}
