package com.bera.webflux.router;

import com.bera.webflux.handler.TodoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TodoRouter {

  @Bean
  RouterFunction<ServerResponse> todoFunction(TodoHandler handler) {
    return RouterFunctions.nest(
        path("/todo"),
        route(POST(""), handler::createTodo)
            .andRoute(GET(""), handler::getTodoList)
            .andRoute(PUT("/done"), handler::updateTodoDone)
            .andRoute(DELETE("/{id}"), handler::deleteTodo));
  }
}
