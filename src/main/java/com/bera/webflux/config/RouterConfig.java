package com.bera.webflux.config;

import com.bera.webflux.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RouterConfig {

  @Bean
  RouterFunction<ServerResponse> helloFunction(HelloHandler handler) {
    return RouterFunctions.route(GET("/"), handler::handleRequest);
  }
}
