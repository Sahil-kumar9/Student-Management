package com.springboot.studentmanagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class Duplicate extends RuntimeException{

    public Duplicate(String message) {
        super(message);
    }
}
