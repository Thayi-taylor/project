package com.project.controller;

import com.project.entity.ScreensEntity;
import com.project.service.ScreensService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreensController {
    private final ScreensService screensService;

    @GetMapping
    public List<ScreensEntity> getAllScreens() {
        return screensService.getAllScreens();
    }

    @GetMapping("/{id}")
    public Optional<ScreensEntity> getScreenById(@PathVariable Integer id) {
        return screensService.getScreenById(id);
    }

    @GetMapping("/theater/{theaterId}")
    public List<ScreensEntity> getScreensByTheaterId(@PathVariable Integer theaterId) {
        return screensService.getScreensByTheaterId(theaterId);
    }
}
