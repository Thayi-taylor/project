package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Movies")
public class MoviesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovieID")
    private Integer movieId;

    @Column(name = "MovieTitle", nullable = false)
    private String movieTitle;

    @Column(name = "MovieGenre")
    private String movieGenre;

    @Column(name = "MovieDuration", nullable = false)
    private Integer movieDuration;

    @Column(name = "MovieReleaseDate")
    private Date movieReleaseDate;

    @Column(name = "MovieAgeRating", nullable = false)
    private Integer movieAgeRating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SchedulesEntity> schedules;
}
