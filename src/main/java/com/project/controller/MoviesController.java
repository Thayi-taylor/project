package com.project.controller;

import com.project.entity.MoviesEntity;
import com.project.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesService moviesService;

    @GetMapping
    public List<MoviesEntity> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<MoviesEntity> getMovieById(@PathVariable Integer id) {
        return moviesService.getMovieById(id);
    }

    @GetMapping("/genre/{genre}")
    public List<MoviesEntity> getMoviesByGenre(@PathVariable String genre) {
        return moviesService.getMoviesByGenre(genre);
    }
}
