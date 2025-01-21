package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Reservations")
public class ReservationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservationID")
    private Integer reservationId;

    @ManyToOne
    @JoinColumn(name = "ScheduleID", nullable = false)
    private SchedulesEntity schedule;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private CustomersEntity customer;

    @Column(name = "TotalPrice", nullable = false)
    private Integer totalPrice;

    @Column(name = "ReservationDate", nullable = false)
    private LocalDateTime reservationDate = LocalDateTime.now();

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservedSeatsEntity> reservedSeats;
}
