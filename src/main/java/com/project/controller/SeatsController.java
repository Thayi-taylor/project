package com.project.controller;

import com.project.entity.SeatsEntity;
import com.project.service.SeatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatsController {
    private final SeatsService seatsService;

    @GetMapping("/screen/{screenId}")
    public List<SeatsEntity> getSeatsByScreenId(@PathVariable Integer screenId) {
        return seatsService.getSeatsByScreenId(screenId);
    }

    @GetMapping("/{seatId}")
    public Optional<SeatsEntity> getSeatById(@PathVariable Integer seatId) {
        return seatsService.getSeatById(seatId);
    }
}
