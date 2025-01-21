package com.project.service;

import com.project.DTO.SeatsDTO;
import com.project.repository.SchedulesRepository;
import com.project.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    public List<SeatsDTO> getSeatsForSchedule(int scheduleId) {
        // 실제 DB에서 screenId 조회
        Integer screenId = findScreenIdByScheduleId(scheduleId);
        if(screenId == null) {
            throw new RuntimeException("해당 스케줄ID에 대한 스크린ID를 찾을 수 없습니다.");
        }
        return seatsRepository.findSeatsByScreenId(screenId);
    }

    private Integer findScreenIdByScheduleId(int scheduleId) {
        return schedulesRepository.findScreenIdByScheduleId(scheduleId);
    }

}
