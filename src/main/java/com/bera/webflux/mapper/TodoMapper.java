package com.bera.webflux.mapper;

import com.bera.webflux.dto.TodoCreateDto;
import com.bera.webflux.dto.TodoDto;
import com.bera.webflux.dto.TodoRequestDto;
import com.bera.webflux.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

  public TodoCreateDto toCreateDto(TodoRequestDto.TodoCreate create);

  public Todo toEntity(TodoCreateDto create);

  public TodoDto toDto(Todo todo);

  public List<TodoDto> toDto(List<Todo> todo);
}
