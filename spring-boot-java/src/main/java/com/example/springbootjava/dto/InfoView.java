package com.example.springbootjava.dto;

import com.example.springbootjava.document.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoView {

    private AnimeDto anime;
    private Movie movie;
}
