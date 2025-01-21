package com.project.service;

import com.project.entity.ReservationsEntity;
import com.project.repository.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationsService {
    private final ReservationsRepository reservationsRepository;

    public List<ReservationsEntity> getReservationsByCustomerId(String customerId) {
        return reservationsRepository.findByCustomer_CustomerId(customerId);
    }

    public Optional<ReservationsEntity> getReservationById(Integer reservationId) {
        return reservationsRepository.findById(reservationId);
    }
}
