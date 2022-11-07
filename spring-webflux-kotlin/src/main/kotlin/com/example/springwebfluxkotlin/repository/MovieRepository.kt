package com.example.springwebfluxkotlin.repository

import com.example.springwebfluxkotlin.document.Movie
import kotlinx.coroutines.flow.Flow
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface MovieRepository : CoroutineCrudRepository<Movie, String> {

    @Aggregation("{ \$sample: {size: 1} }")
    fun findOneRandomMovie(): Flow<Movie>

    @Aggregation("{ \$sample: {size: ?0} }")
    fun findRandomMovies(count: Int): Flow<Movie>
}