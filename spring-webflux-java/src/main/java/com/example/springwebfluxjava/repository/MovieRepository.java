package com.example.springwebfluxjava.repository;

import com.example.springwebfluxjava.document.Movie;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {

    @Aggregation("{ $sample: {size: 1} }")
    Flux<Movie> findOneRandomMovie();
    @Aggregation("{ $sample: {size: ?0} }")
    Flux<Movie> findRandomMovies(Integer count);
}
