package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ReservedSeats")
@Getter
@Setter
public class ReservedSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservedSeatId")
    private int reservedSeatId;

    @ManyToOne
    @JoinColumn(name = "seatId", nullable = false)
    private SeatsEntity bookedSeat;
}
