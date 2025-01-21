package com.project.service;

import com.project.entity.SchedulesEntity;
import com.project.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchedulesService {
    private final SchedulesRepository schedulesRepository;

    public List<SchedulesEntity> getSchedulesByMovieId(Integer movieId) {
        return schedulesRepository.findByMovie_MovieId(movieId);
    }

    public Optional<SchedulesEntity> getScheduleById(Integer scheduleId) {
        return schedulesRepository.findById(scheduleId);
    }

    public List<SchedulesEntity> getSchedulesByDateRange(LocalDate startDate, LocalDate endDate) {
        return schedulesRepository.findByMovieShowDateBetween(startDate, endDate);
    }
}
