package com.example.lastproject.service;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.models.Films;
import com.example.lastproject.repository.FilmDtoRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmDTOService {

    private final FilmDtoRepos filmDtoRepos;

    public Optional<FilmDTO> findByKinopoiskId(Long id) {
        return filmDtoRepos.findByKinopoiskId(id);
    }

    public Optional<FilmDTO> findByNameRu(String nameRu) {
        return filmDtoRepos.findByNameRu(nameRu);
    }

    public Optional<FilmDTO> findFilmsByRatingTo(Double ratingTo) {
        return filmDtoRepos.findFilmsByRatingTo(ratingTo);
    }

    public Optional<FilmDTO> findFilmsByRatingFrom(Double ratingFrom) {
        return filmDtoRepos.findFilmsByRatingFrom(ratingFrom);
    }

    public Optional<FilmDTO> findFilmsByGenre(String genre) {
        return filmDtoRepos.findFilmsByGenre(genre);
    }

    public Optional<FilmDTO> findFilmsByDateOfCreate(Integer dateOfCreate) {
        return filmDtoRepos.findFilmsByDateOfCreate(dateOfCreate);
    }

    public Page<FilmDTO > getFilms(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmDtoRepos.findAll(pageable);
    }
}
