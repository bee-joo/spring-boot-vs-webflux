package com.example.springwebfluxjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeDto implements Serializable {

    @JsonProperty("mal_id")
    int id;

    @JsonProperty("title_english")
    String titleEnglish;

    @JsonProperty("title_japanese")
    String titleJapanese;

    @JsonProperty("title_synonyms")
    List<String> titleSynonyms;

    String title, type, source, status, duration, synopsis;
    int episodes, year;
    boolean airing;
}
