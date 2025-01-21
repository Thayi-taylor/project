package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservedSeats")
@Getter
@Setter
public class ReservedSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservedSeatId;

    @ManyToOne
    @JoinColumn(name = "reservationId", referencedColumnName = "ReservationId")
    private Reservations reservations;

    @ManyToOne
    @JoinColumn(name = "seatId", referencedColumnName = "SeatId")
    private Seats seats;

    @ManyToOne
    @JoinColumn(name = "SeatPrice", referencedColumnName = "SeatPrice")
    private SeatsGrade seatsGrade;
}
