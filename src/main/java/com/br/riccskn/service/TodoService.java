package com.br.riccskn.service;

import com.br.riccskn.dto.input.TodoInputDto;
import com.br.riccskn.dto.output.ResponseOutput;
import com.br.riccskn.model.Todo;

public interface TodoService {

    ResponseOutput createTodo(TodoInputDto todo);

    ResponseOutput deleteTodo(Long id);

    ResponseOutput findTodoById(Long id);

}
