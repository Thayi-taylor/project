package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MoviesDTO {
    private int MovieId;
    private String MovieTitle;
    private String MovieGenre;
    private int MovieDuration;
    private LocalDate MovieReleaseDate;
    private int MovieAgeRating;
}
