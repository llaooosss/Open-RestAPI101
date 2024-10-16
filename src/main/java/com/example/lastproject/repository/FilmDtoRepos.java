package com.example.lastproject.repository;

import com.example.lastproject.DTO.FilmDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmDtoRepos extends JpaRepository<FilmDTO, Long> {

    Optional<FilmDTO> findByKinopoiskId(Long id);

    Optional<FilmDTO> findByNameRu(String nameRu);

    Optional<FilmDTO> findFilmsByRatingTo(Double ratingTo);

    Optional<FilmDTO> findFilmsByRatingFrom(Double ratingFrom);

    Optional<FilmDTO> findFilmsByGenre(String genre);

    Optional<FilmDTO> findFilmsByDateOfCreate(Integer dateOfCreate);
}
