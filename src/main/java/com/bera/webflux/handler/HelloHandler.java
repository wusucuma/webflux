package com.bera.webflux.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class HelloHandler {

    public Mono<ServerResponse> handleRequest(ServerRequest req) {
        return ServerResponse.ok().body(Mono.just(Arrays.asList(1,2,3)), List.class);
    }
}
