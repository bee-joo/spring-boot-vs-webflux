package com.example.springbootjava.service;

import com.example.springbootjava.document.Movie;
import com.example.springbootjava.dto.InfoView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApiService {
    ResponseEntity<InfoView> getAnimeAndMovie(Long id);
    ResponseEntity<List<Movie>> getRandomMovies(Integer count);
}
