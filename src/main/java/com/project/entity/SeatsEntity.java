package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Seats")
@Getter
@Setter
public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatId")
    private int seatId;

    @Column(name = "rowNumber")
    private String rowNumber;

    @Column(name = "seatNumber")
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "screenId", referencedColumnName = "screenId")
    private ScreensEntity screenRef;
}
