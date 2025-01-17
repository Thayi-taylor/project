package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Seats")
@Getter
@Setter
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private String rowNumber;
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "screenId", referencedColumnName = "ScreenId")
    private Screens screens;
}
