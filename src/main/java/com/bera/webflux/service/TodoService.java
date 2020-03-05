package com.bera.webflux.service;

import com.bera.webflux.dto.TodoCreateDto;
import com.bera.webflux.dto.TodoDto;
import com.bera.webflux.entity.Todo;
import com.bera.webflux.mapper.TodoMapper;
import com.bera.webflux.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

  private final TodoMapper todoMapper;
  private final TodoRepository todoRepository;

  public TodoDto save(TodoCreateDto createDto) {
      return todoMapper.toDto(todoRepository.save(todoMapper.toEntity(createDto)));
  }

  public List<TodoDto> findAll() {
      return todoMapper.toDto(todoRepository.findAll());
  }
}
