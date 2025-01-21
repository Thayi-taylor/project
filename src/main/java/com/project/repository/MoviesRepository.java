package com.project.repository;

import com.project.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity, Integer> {
    List<MoviesEntity> findByMovieGenre(String genre);

    List<MoviesEntity> findByMovieTitleContaining(String title);
}
