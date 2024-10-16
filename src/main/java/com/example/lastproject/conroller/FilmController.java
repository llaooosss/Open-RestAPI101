package com.example.lastproject.conroller;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.models.Films;
import com.example.lastproject.service.FilmDTOService;
import com.example.lastproject.service.FilmFilters;
import com.example.lastproject.service.FilmService;
import com.example.lastproject.util.FilmAlreadyExistsException;
import com.example.lastproject.util.FilmNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/films")
public class FilmController {

    private final FilmService filmService;
    private final FilmFilters filmFilters;
    private final FilmDTOService filmDTOService;

    @GetMapping("/pages")
    public Page<Films> getFilms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size) {
        return filmService.getFilms(page, size);
    }

    @GetMapping("/all")
    public Optional<List<Films>> getAllFilms() {
        return Optional.of(filmService.findAll());
    }


    @GetMapping("/name/{name}")
    public Optional<Films> getFilmsByName(@PathVariable String name) {
        return Optional.ofNullable(filmService.findByFilmsName(name).orElseThrow(() -> new FilmNotFoundException("Фильм с имененм " + name + " уже существует")));
    }

    @GetMapping("/{id}")
    public Optional<Films> getFilmById(@PathVariable Long id) {
        return Optional.ofNullable(filmService.findByFilmId(id).orElseThrow(() -> new FilmNotFoundException("Фильм с ID " + id + " уже существует")));
    }

    @GetMapping("/rating/{rating}")
    public Optional<List<Films>> getFilmsByRating(@PathVariable Double rating) {
        return filmService.findByRating(rating);
    }

    @GetMapping("/year/{year}")
    public Optional<List<Films>> getFilmsByYear(@PathVariable Integer year) {
        return filmService.findByYear(year);
    }


    // Реализация добавления фильма его

    @PostMapping("/saveFilm")
    public Optional<Boolean> saveFilms(FilmDTO filmDTO) {
        return Optional.ofNullable(Optional.of(filmFilters.saveFilm(filmDTO)).orElseThrow(() -> new FilmAlreadyExistsException(("Данный фильм уже существует: " + filmDTO))));
    }


    // Реализация ДТО

    @GetMapping("/kinopoisk/{id}")
    public FilmDTO getFilmByKinopoiskId(@PathVariable Long id) {
        return filmDTOService.findByKinopoiskId(id).orElse(null);
    }

    @GetMapping("/name")
    public FilmDTO getFilmByNameRu(@RequestParam String nameRu) {
        return filmDTOService.findByNameRu(nameRu).orElse(null);
    }


    @GetMapping("/rating/to/{ratingTo}")
    public FilmDTO getFilmsByRatingTo(@PathVariable Double ratingTo) {
        return filmDTOService.findFilmsByRatingTo(ratingTo).orElse(null);
    }

    @GetMapping("/rating/from/{ratingFrom}")
    public FilmDTO getFilmsByRatingFrom(@PathVariable Double ratingFrom) {
        return filmDTOService.findFilmsByRatingFrom(ratingFrom).orElse(null);
    }

    @GetMapping("/genre")
    public FilmDTO getFilmsByGenre(@RequestParam String genre) {
        return filmDTOService.findFilmsByGenre(genre).orElse(null);
    }

    @GetMapping("/date/{dateOfCreate}")
    public FilmDTO getFilmsByDateOfCreate(@PathVariable Integer dateOfCreate) {
        return filmDTOService.findFilmsByDateOfCreate(dateOfCreate).orElse(null);
    }


//    public Optional<FilmDTO> findByKinopoiskId(Long id);
//
//    Optional<FilmDTO> findByNameRu(String nameRu);
//
//    Optional<FilmDTO> findFilmsByYear(Integer year);
//
//    Optional<FilmDTO> findFilmsByRatingTo(Double ratingTo);
//
//    Optional<FilmDTO> findFilmsByRatingFrom(Double ratingFrom);
//
//    Optional<FilmDTO> findFilmsByGenre(String genre);
//
//    Optional<FilmDTO> findFilmsByDateOfCreate(Integer dateOfCreate);

}
