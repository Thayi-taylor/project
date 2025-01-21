package com.project.service;

import com.project.entity.ScreensEntity;
import com.project.repository.ScreensRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreensService {
    private final ScreensRepository screensRepository;

    public List<ScreensEntity> getAllScreens() {
        return screensRepository.findAll();
    }

    public Optional<ScreensEntity> getScreenById(Integer id) {
        return screensRepository.findById(id);
    }

    public List<ScreensEntity> getScreensByTheaterId(Integer theaterId) {
        return screensRepository.findByTheater_TheaterId(theaterId);
    }
}
