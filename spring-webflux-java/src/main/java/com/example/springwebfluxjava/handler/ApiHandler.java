package com.example.springwebfluxjava.handler;

import com.example.springwebfluxjava.document.Movie;
import com.example.springwebfluxjava.dto.JikanResponse;
import com.example.springwebfluxjava.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ApiHandler {
    private final MovieRepository movieRepository;
    private WebClient client;

    public Mono<ServerResponse> getAnimeAndMovie(ServerRequest req) {
        var id = req.pathVariable("id");
        var anime = client.get()
                .uri("https://api.jikan.moe/v4/anime/%s".formatted(id))
                .retrieve()
                .bodyToMono(JikanResponse.class)
                .flatMap(it -> Mono.just(it.getAnimeDto()));

        var movie = movieRepository.findOneRandomMovie();

        return ServerResponse.ok().body(Flux.merge(anime, movie), Flux.class);
    }

    public Mono<ServerResponse> getMovies(ServerRequest req) {
        var count = req.queryParam("count");

        int countVal;
        try {
            countVal = count.map(Integer::parseInt).orElse(10);
        } catch (NumberFormatException e) {
            return ServerResponse.badRequest().build();
        }

        if (countVal > 0 && countVal <= 25) {
            var movies = movieRepository.findRandomMovies(countVal);
            return ServerResponse.ok().body(movies, Movie.class);
        }

        return ServerResponse.badRequest().build();
    }
}
