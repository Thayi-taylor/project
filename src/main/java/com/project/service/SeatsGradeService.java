package com.project.service;

import com.project.entity.SeatsGradeEntity;
import com.project.repository.SeatsGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatsGradeService {
    private final SeatsGradeRepository seatsGradeRepository;

    public Optional<SeatsGradeEntity> getSeatGradeById(Integer gradeId) {
        return seatsGradeRepository.findById(gradeId);
    }
}
