package com.project.repository;

import com.project.entity.ReservedSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedSeatsRepository extends JpaRepository<ReservedSeatsEntity, Integer> {
    List<ReservedSeatsEntity> findByReservation_ReservationId(Integer reservationId);

    List<ReservedSeatsEntity> findBySeat_SeatId(Integer seatId);
}
