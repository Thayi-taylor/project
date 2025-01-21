package com.project.service;

import com.project.entity.TheatersEntity;
import com.project.repository.TheatersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TheatersService {
    private final TheatersRepository theatersRepository;

    public List<TheatersEntity> getAllTheaters() {
        return theatersRepository.findAll();
    }

    public Optional<TheatersEntity> getTheaterById(Integer id) {
        return theatersRepository.findById(id);
    }
}
