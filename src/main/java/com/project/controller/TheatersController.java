package com.project.controller;

import com.project.entity.TheatersEntity;
import com.project.service.TheatersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theaters")
@RequiredArgsConstructor
public class TheatersController {
    private final TheatersService theatersService;

    @GetMapping
    public List<TheatersEntity> getAllTheaters() {
        return theatersService.getAllTheaters();
    }

    @GetMapping("/{id}")
    public Optional<TheatersEntity> getTheaterById(@PathVariable Integer id) {
        return theatersService.getTheaterById(id);
    }
}
