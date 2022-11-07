package com.example.springwebfluxkotlin.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "movies")
data class Movie(
    var year: String,
    var title: String,
    var genres: List<String?> = emptyList(),
    var cast: List<String?> = emptyList(),
    var plot: String? = null,
    var fullplot: String? = null,
    var poster: String? = null,
    @Id
    var id: String? = null
)
