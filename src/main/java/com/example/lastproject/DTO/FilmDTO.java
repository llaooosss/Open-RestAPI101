package com.example.lastproject.DTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class FilmDTO {
    long kinopoiskId;
    String nameRu;
    int year;
    double ratingTo;
    double ratingFrom;
    String genre;
    int dateOfCreate;

//    public boolean Duplicate(FilmDTO duplo) {
//        if (duplo == null) {
//            return false;
//        }
//
//        return this.kinopoiskId == duplo.kinopoiskId &&
//                this.nameRu.equals(duplo.nameRu);
//    }
//
//    public boolean hasDuplicates(List<FilmDTO> films) {
//        return films.stream()
//                .distinct()
//                .collect(Collectors.groupingBy(film -> film))
//                .values().stream()
//                .anyMatch(group -> group.size() > 1);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof FilmDTO filmDTO)) return false;
//        return getKinopoiskId() == filmDTO.getKinopoiskId() && getYear() == filmDTO.getYear() && Double.compare(
//                filmDTO.getRatingTo(),
//                getRatingTo()) == 0 && Double.compare(filmDTO.getRatingFrom(),
//                getRatingFrom()) == 0 && getDateOfCreate() == filmDTO.getDateOfCreate() && Objects.equals(getNameRu(),
//                filmDTO.getNameRu()) && Objects.equals(getGenre(),
//                filmDTO.getGenre()
//        );
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getKinopoiskId(), getNameRu(), getYear(), getRatingTo(), getRatingFrom(), getGenre(), getDateOfCreate());
//    }
}
