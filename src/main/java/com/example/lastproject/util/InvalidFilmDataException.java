package com.example.lastproject.util;

public class InvalidFilmDataException extends RuntimeException {
    public InvalidFilmDataException(String message) {
        super("Invalid film data: " + message);
    }
}
