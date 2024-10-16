package com.example.lastproject.util;

public class FilmDTOConversionException extends RuntimeException {
    public FilmDTOConversionException(String message) {
        super("Error converting Film to FilmDTO: " + message);
    }
}
