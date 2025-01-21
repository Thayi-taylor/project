package com.project.repository;

import com.project.entity.SchedulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<SchedulesEntity, Integer> {
    List<SchedulesEntity> findByMovie_MovieId(Integer movieId);

    List<SchedulesEntity> findByScreen_ScreenId(Integer screenId);

    List<SchedulesEntity> findByMovieShowDateBetween(LocalDate startDate, LocalDate endDate);
}
