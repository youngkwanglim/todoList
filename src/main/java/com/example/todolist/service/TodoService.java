package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.dto.CreateTodoRequest;
import com.example.todolist.dto.GetTodoList;
import com.example.todolist.dto.UpdateTodoRequest;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void createTodo(CreateTodoRequest request) {

        Todo todo = new Todo(request);

        todoRepository.save(todo);

    }

    public void updateTodo(UpdateTodoRequest request) {

        Todo todo = todoRepository.findById(request.getTodoId()).orElseThrow(RuntimeException::new);

        todo.updateTodo(request);
    }


    public void deleteTodo(Long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(RuntimeException::new);

        todoRepository.delete(todo);
    }


    public GetTodoList getTodoList(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Todo> todoList = todoRepository.findAll(pageable);

        return new GetTodoList(todoList);
    }
}
