package com.example.springbootjava.controller;

import com.example.springbootjava.document.Movie;
import com.example.springbootjava.dto.InfoView;
import com.example.springbootjava.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<InfoView> getAnime(@PathVariable Long id) {
        return apiService.getAnimeAndMovie(id);
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(defaultValue = "10") Integer count) {
        return apiService.getRandomMovies(count);
    }
}
