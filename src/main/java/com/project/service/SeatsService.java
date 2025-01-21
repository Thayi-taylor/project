package com.project.service;

import com.project.DTO.SeatsDTO;
import com.project.repository.SchedulesRepository;
import com.project.repository.SeatsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SeatsService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private SchedulesRepository scheduleRepository;

    public List<SeatsDTO> getSeatsForSchedule(int scheduleId) {
        // 실제 DB에서 screenId 조회
        Integer screenId = findScreenIdByScheduleId(scheduleId);
        if (screenId == null) {
            throw new RuntimeException("해당 scheduleId에 대한 screenId를 찾을 수 없습니다.");
        }
        return seatsRepository.findSeatsByScreenId(screenId);
    }

    private Integer findScreenIdByScheduleId(int scheduleId) {
        return scheduleRepository.findScreenIdByScheduleId(scheduleId);
    }
}


