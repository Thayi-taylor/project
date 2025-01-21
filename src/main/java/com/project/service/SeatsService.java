package com.project.service;

import com.project.entity.SeatsEntity;
import com.project.repository.SeatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatsService {
    private final SeatsRepository seatsRepository;

    public List<SeatsEntity> getSeatsByScreenId(Integer screenId) {
        return seatsRepository.findByScreen_ScreenId(screenId);
    }

    public Optional<SeatsEntity> getSeatById(Integer seatId) {
        return seatsRepository.findById(seatId);
    }

    public SeatsEntity getSeatByScreenAndPosition(Integer screenId, String row, Integer seatNumber) {
        return seatsRepository.findByScreen_ScreenIdAndRowNumberAndSeatNumber(screenId, row, seatNumber);
    }
}
