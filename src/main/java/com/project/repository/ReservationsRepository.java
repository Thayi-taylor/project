package com.project.repository;

import com.project.entity.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<ReservationsEntity, Integer> {
    List<ReservationsEntity> findByCustomer_CustomerId(String customerId);

    List<ReservationsEntity> findBySchedule_ScheduleId(Integer scheduleId);
}
