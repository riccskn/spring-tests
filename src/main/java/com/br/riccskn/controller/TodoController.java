package com.br.riccskn.controller;

import com.br.riccskn.dto.input.TodoInputDto;
import com.br.riccskn.dto.output.ResponseOutput;
import com.br.riccskn.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/todo")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping()
    public ResponseEntity<ResponseOutput> createTodo(@RequestBody TodoInputDto todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseOutput> deleteTodo(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(todoService.deleteTodo(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOutput> getTodoById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(todoService.findTodoById(id), HttpStatus.OK);
    }

}
