package com.project.controller;

import com.project.entity.SchedulesEntity;
import com.project.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class SchedulesController {
    private final SchedulesService schedulesService;

    @GetMapping("/movie/{movieId}")
    public List<SchedulesEntity> getSchedulesByMovieId(@PathVariable Integer movieId) {
        return schedulesService.getSchedulesByMovieId(movieId);
    }

    @GetMapping("/{scheduleId}")
    public Optional<SchedulesEntity> getScheduleById(@PathVariable Integer scheduleId) {
        return schedulesService.getScheduleById(scheduleId);
    }

    @GetMapping("/date-range")
    public List<SchedulesEntity> getSchedulesByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return schedulesService.getSchedulesByDateRange(startDate, endDate);
    }
}
