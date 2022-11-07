package com.example.springwebfluxkotlin.dto

import com.example.springwebfluxkotlin.document.Movie

data class InfoView(
    val anime: ResponseData.AnimeDto,
    val movie: Movie
)
