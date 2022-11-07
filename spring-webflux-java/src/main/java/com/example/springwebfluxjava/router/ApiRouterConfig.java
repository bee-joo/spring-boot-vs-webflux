package com.example.springwebfluxjava.router;

import com.example.springwebfluxjava.handler.ApiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebFilter;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ApiRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> apiRouter(ApiHandler apiHandler) {
        return RouterFunctions.nest(path("/api"),
                route(GET("/anime/{id}"), apiHandler::getAnimeAndMovie)
                        .andRoute(GET("/movie"), apiHandler::getMovies));
    }

    @Bean
    WebFilter handleExceptions() {
        return (exchange, next) -> next.filter(exchange)
                .onErrorResume(e -> {
                    var response = exchange.getResponse();
                    if (e instanceof WebClientResponseException ex) {
                        response.setStatusCode(ex.getStatusCode());
                    } else {
                        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                    return response.setComplete();
                });
    }
}
