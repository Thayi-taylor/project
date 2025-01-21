package com.project.service;

import com.project.entity.MoviesEntity;
import com.project.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesService {
    private final MoviesRepository moviesRepository;

    public List<MoviesEntity> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<MoviesEntity> getMovieById(Integer movieId) {
        return moviesRepository.findById(movieId);
    }

    public List<MoviesEntity> getMoviesByGenre(String genre) {
        return moviesRepository.findByMovieGenre(genre);
    }
}
