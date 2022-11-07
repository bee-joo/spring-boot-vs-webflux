package com.example.springbootjava.service;

import com.example.springbootjava.document.Movie;
import com.example.springbootjava.dto.InfoView;
import com.example.springbootjava.dto.JikanResponse;
import com.example.springbootjava.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final MovieRepository movieRepository;

    @Override
    public ResponseEntity<InfoView> getAnimeAndMovie(Long id) {
        JikanResponse anime;
        try {
            anime = restTemplate.getForObject("https://api.jikan.moe/v4/anime/%d".formatted(id), JikanResponse.class);
        } catch (RestClientResponseException e) {
            return ResponseEntity.status(e.getRawStatusCode()).build();
        }

        if (anime == null || anime.getAnimeDto() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        var movie = movieRepository
                .findOneRandomMovie();

        return ResponseEntity.ok(new InfoView(anime.getAnimeDto(), movie));
    }

    @Override
    public ResponseEntity<List<Movie>> getRandomMovies(Integer count) {
        if (count < 1 || count > 25)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(movieRepository.findRandomMovies(count));
    }
}
