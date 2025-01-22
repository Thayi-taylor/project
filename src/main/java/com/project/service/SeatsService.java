package com.project.service;

import com.project.DTO.SeatsDTO;
import com.project.repository.SchedulesRepository;
import com.project.repository.SeatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatsService {

    private final SeatsRepository seatsRepository;
    private final SchedulesRepository scheduleRepository;

    // ✅ Lombok 없이 직접 생성자 추가
    public SeatsService(SeatsRepository seatsRepository, SchedulesRepository scheduleRepository) {
        this.seatsRepository = seatsRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<SeatsDTO> getSeatsForSchedule(int scheduleId) {
        // 🔥 디버깅을 위한 로그 추가
        Integer screenId = findScreenIdByScheduleId(scheduleId);
        System.out.println("찾은 screenId: " + screenId);  // ✅ screenId가 null인지 확인

        if (screenId == null) {
            throw new RuntimeException("해당 scheduleId (" + scheduleId + ")에 대한 screenId를 찾을 수 없습니다.");
        }

        List<SeatsDTO> seatsByScreenId = seatsRepository.findSeatsByScreenId(screenId);
        System.out.println("조회된 좌석 수: " + (seatsByScreenId != null ? seatsByScreenId.size() : "null"));  // ✅ seats가 null인지 확인

        return seatsByScreenId != null ? seatsByScreenId : new ArrayList<>(); // ✅ seats가 null이면 빈 리스트 반환
    }

    private Integer findScreenIdByScheduleId(int scheduleId) {
        return scheduleRepository.findScreenIdByScheduleId(scheduleId);
    }
}


