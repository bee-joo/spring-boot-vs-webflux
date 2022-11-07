package com.example.springbootjava.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder(alphabetic = true)
public class AnimeDto implements Serializable {

    @JsonProperty("mal_id")
    int id;

    @JsonProperty("title_english")
    String titleEnglish;

    @JsonProperty("title_japanese")
    String titleJapanese;

    @JsonProperty("title_synonyms")
    List<String> titleSynonyms;

    String title, type, source, status, duration, synopsis, url;
    int episodes, year;
    boolean airing;
}
