package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ReservedSeats")
public class ReservedSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservedSeatID")
    private Integer reservedSeatId;

    @ManyToOne
    @JoinColumn(name = "ReservationID", nullable = false)
    private ReservationsEntity reservation;

    @ManyToOne
    @JoinColumn(name = "SeatID", nullable = false)
    private SeatsEntity seat;
}
