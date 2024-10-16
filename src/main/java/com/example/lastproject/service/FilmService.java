package com.example.lastproject.service;

import com.example.lastproject.models.Films;
import com.example.lastproject.repository.FilmRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepos filmRepos;

    public List<Films> findAll() {
        return filmRepos.findAll();
    }

    public Optional<Films> findByFilmsName(String name) {
        return filmRepos.findByFilmName(name);
    }

    public Optional<Films> findByFilmId(Long id) {
        return filmRepos.findByFilmId(id);
    }

    public Optional<List<Films>> findByYear(Integer year) {
        return Optional.of(filmRepos.findByYear(year));
    }

    public Optional<List<Films>> findByRating(Double rating) {
        return Optional.of(filmRepos.findByRating(rating));
    }

    public Page<Films> getFilms(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmRepos.findAll(pageable);
    }

}
