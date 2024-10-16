package com.example.lastproject.service;

import com.example.lastproject.DTO.FilmDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FilmFilters {

    private List<FilmDTO> films;

    public boolean saveFilm(FilmDTO filmDTO) {
        for (FilmDTO exFilms : films) {
            if (exFilms.getNameRu().equalsIgnoreCase(filmDTO.getNameRu()) &&
                    exFilms.getKinopoiskId() == filmDTO.getKinopoiskId()) {
                // Фильм с таким названием и айди существует
                return false;
            }
        }
        films.add(filmDTO); // Добавляем фильм, если дубликатов нет
        return true;
    }


    public List<FilmDTO> filterFilms(double ratingTo, double ratingFrom) {
        return films.stream()
                .filter(film -> film.getRatingTo() >= ratingTo && film.getRatingFrom() >= ratingFrom)
                .collect(Collectors.toList());
    }

}
