package com.example.springwebfluxkotlin.router

import com.example.springwebfluxkotlin.handler.ApiHandler
import kotlinx.coroutines.handleCoroutineException
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ApiRouterConfig(private val apiHandler: ApiHandler) {

    @Bean
    fun apiRouter() = coRouter {
        "/api".nest {
            GET("/anime/{id}", apiHandler::getAnimeAndMovie)
            GET("/movie", apiHandler::getMovies)
        }

        onError<Exception> { e, _ ->
            when (e) {
                is WebClientResponseException -> ServerResponse.status(e.rawStatusCode).buildAndAwait()
                else -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).buildAndAwait()
            }
        }
    }
}