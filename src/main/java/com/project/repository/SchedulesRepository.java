package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    // 특정 스케줄ID에 해당하는 스크린ID 조회
    @Query("""
            SELECT s.screens.screenId
            FROM Schedules s
            WHERE s.scheduleId = :scheduleId
           """)
    Integer findScreenIdByScheduleId(int scheduleId);
}
