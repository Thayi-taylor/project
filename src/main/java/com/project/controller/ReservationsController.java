package com.project.controller;

import com.project.entity.ReservationsEntity;
import com.project.service.ReservationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationsController {
    private final ReservationsService reservationsService;

    @GetMapping("/customer/{customerId}")
    public List<ReservationsEntity> getReservationsByCustomerId(@PathVariable String customerId) {
        return reservationsService.getReservationsByCustomerId(customerId);
    }

    @GetMapping("/{reservationId}")
    public Optional<ReservationsEntity> getReservationById(@PathVariable Integer reservationId) {
        return reservationsService.getReservationById(reservationId);
    }
}
