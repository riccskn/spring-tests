package com.br.riccskn.service.impl;

import com.br.riccskn.dto.input.TodoInputDto;
import com.br.riccskn.dto.output.ResponseOutput;
import com.br.riccskn.dto.output.TodoOutputDto;
import com.br.riccskn.exception.ApiException;
import com.br.riccskn.model.Todo;
import com.br.riccskn.repository.TodoRepository;
import com.br.riccskn.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ResponseOutput createTodo(TodoInputDto todo) {
        log.info(String.format("Saving new de todo: %s...", todo.getName()));

        Todo todoSaved = todoRepository.save(modelMapper.map(todo, Todo.class));
        return new ResponseOutput(modelMapper.map(todoSaved, TodoOutputDto.class), true, "New todo created");
    }

    @Override
    public ResponseOutput deleteTodo(Long id) {
        Todo todoSaved = todoRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "Todo not found!"));

        log.info(String.format("Deleting todo: %s...", todoSaved.getName()));
        todoRepository.delete(todoSaved);

        return new ResponseOutput(modelMapper.map(todoSaved, TodoOutputDto.class), true, "Todo deleted!");
    }

    @Override
    public ResponseOutput findTodoById(Long id) {

        Todo todoSaved = todoRepository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST, "Todo not found!"));

        return new ResponseOutput(modelMapper.map(todoSaved, TodoOutputDto.class), true, String.format("Getting todo %s...", todoSaved.getName()));
    }
}
