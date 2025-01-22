package com.project.repository;

import com.project.entity.SchedulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulesRepository extends JpaRepository<SchedulesEntity, Integer> {

    @Query("SELECT s.scheduledScreen.screenId FROM SchedulesEntity s WHERE s.scheduleId = :scheduleId")
    Integer findScreenIdByScheduleId(int scheduleId);
}
