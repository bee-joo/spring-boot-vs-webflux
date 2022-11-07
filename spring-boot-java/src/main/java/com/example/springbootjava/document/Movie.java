package com.example.springbootjava.document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "movies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Movie {

    @Id
    String id;
    String year, plot, poster, title, fullplot;
    List<String> genres, cast;
}
