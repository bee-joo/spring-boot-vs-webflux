package com.example.springwebfluxjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseObject {
    private int status;
    private String message;
}
