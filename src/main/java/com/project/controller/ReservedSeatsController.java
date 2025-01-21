package com.project.controller;

import com.project.entity.ReservedSeatsEntity;
import com.project.service.ReservedSeatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserved-seats")
@RequiredArgsConstructor
public class ReservedSeatsController {
    private final ReservedSeatsService reservedSeatsService;

    @GetMapping("/reservation/{reservationId}")
    public List<ReservedSeatsEntity> getReservedSeatsByReservationId(@PathVariable Integer reservationId) {
        return reservedSeatsService.getReservedSeatsByReservationId(reservationId);
    }

    @GetMapping("/seat/{seatId}")
    public List<ReservedSeatsEntity> getReservedSeatsBySeatId(@PathVariable Integer seatId) {
        return reservedSeatsService.getReservedSeatsBySeatId(seatId);
    }
}
