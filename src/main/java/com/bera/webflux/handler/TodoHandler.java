package com.bera.webflux.handler;

import com.bera.webflux.dto.TodoRequestDto;
import com.bera.webflux.mapper.TodoMapper;
import com.bera.webflux.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class TodoHandler {

  private final TodoMapper todoMapper;
  private final TodoService todoService;

  public Mono<ServerResponse> createTodo(ServerRequest req) {
    return req.bodyToMono(TodoRequestDto.TodoCreate.class)
        .map(todoCreate -> todoMapper.toCreateDto(todoCreate))
        .flatMap(todoCreateDto -> Mono.fromCallable(() -> todoService.save(todoCreateDto)))
        .flatMap(todoDto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());
  }

  public Mono<ServerResponse> getTodoList(ServerRequest req) {
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(todoService.findAll()));
  }
}
