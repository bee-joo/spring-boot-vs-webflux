package com.example.springbootjava.repository;

import com.example.springbootjava.document.Movie;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    @Aggregation("{ $sample: {size: 1} }")
    Movie findOneRandomMovie();
    @Aggregation("{ $sample: {size: ?0} }")
    List<Movie> findRandomMovies(Integer count);
}
