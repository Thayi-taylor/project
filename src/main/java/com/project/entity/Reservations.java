package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "scheduleId", referencedColumnName = "ScheduleId")
    private Schedules schedules;

    @ManyToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId")
    private Customers customers;

    private int totalPrice;


}
