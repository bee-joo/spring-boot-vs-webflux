package com.example.springwebfluxjava.document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "movies")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Movie implements Serializable {

    @Id
    String id;
    String year, plot, poster, title, fullplot;
    List<String> genres, cast;
}

