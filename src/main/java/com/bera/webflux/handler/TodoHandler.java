package com.bera.webflux.handler;

import com.bera.webflux.dto.TodoRequestDto;
import com.bera.webflux.dto.TodoUpdateDto;
import com.bera.webflux.mapper.TodoMapper;
import com.bera.webflux.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
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
        .flatMap(
            todoDto ->
                ServerResponse.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .build());
  }

  public Mono<ServerResponse> getTodoList(ServerRequest req) {
    return Flux.fromIterable(todoService.findAll())
        .collectList()
        .flatMap(
            todoDtoList ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(todoDtoList)));
  }

  public Mono<ServerResponse> updateTodoDone(ServerRequest req) {
    return req.bodyToMono(TodoRequestDto.TodoDoneUpdate.class)
        .map(todoDoneUpdate -> todoMapper.toUpdateDto(todoDoneUpdate))
        .flatMap(todoUpdateDto -> Mono.fromCallable(() -> todoService.updateDone(todoUpdateDto)))
        .flatMap(todoDto -> ServerResponse.ok().build());
  }

  public Mono<ServerResponse> deleteTodo(ServerRequest req) {
    String id = req.pathVariable("id");
    return Mono.fromRunnable(() -> todoService.deleteTodo(Long.valueOf(id)))
        .flatMap(object -> ServerResponse.ok().build());
  }
}
