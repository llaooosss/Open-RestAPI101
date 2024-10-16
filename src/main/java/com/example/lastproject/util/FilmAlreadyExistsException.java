package com.example.lastproject.util;

public class FilmAlreadyExistsException extends RuntimeException {
    public FilmAlreadyExistsException(String title) {
        super("Film already exists with title: " + title);
    }
}