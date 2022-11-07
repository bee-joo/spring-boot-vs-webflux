package com.example.springwebfluxkotlin.handler

import com.example.springwebfluxkotlin.dto.ResponseData
import com.example.springwebfluxkotlin.repository.MovieRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.server.*

@Component
class ApiHandler(
    private val movieRepository: MovieRepository,
    private val client: WebClient
) {

    suspend fun getAnimeAndMovie(req: ServerRequest) = coroutineScope {
        val id = req.pathVariable("id")
        val anime = async {
            client.get()
                .uri("https://api.jikan.moe/v4/anime/$id")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .awaitBody<ResponseData>()
                .data
        }

        val movie = async {
            movieRepository.findOneRandomMovie()
        }

        ServerResponse.ok()
            .json()
            .bodyAndAwait(merge(flowOf(anime.await()), movie.await()))
    }

    suspend fun getMovies(req: ServerRequest): ServerResponse {
        val count = try {
            req.queryParamOrNull("count")?.toInt() ?: 10
        } catch (e: NumberFormatException) {
            return ServerResponse.badRequest().buildAndAwait()
        }

        return if (count in 1..25) {
            ServerResponse.ok()
                .json()
                .bodyAndAwait(movieRepository.findRandomMovies(count))
        } else {
            ServerResponse.badRequest().buildAndAwait()
        }
    }

}