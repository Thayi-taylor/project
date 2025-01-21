package com.project.service;

import com.project.entity.ReservedSeatsEntity;
import com.project.repository.ReservedSeatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservedSeatsService {
    private final ReservedSeatsRepository reservedSeatsRepository;

    public List<ReservedSeatsEntity> getReservedSeatsByReservationId(Integer reservationId) {
        return reservedSeatsRepository.findByReservation_ReservationId(reservationId);
    }

    public List<ReservedSeatsEntity> getReservedSeatsBySeatId(Integer seatId) {
        return reservedSeatsRepository.findBySeat_SeatId(seatId);
    }
}
