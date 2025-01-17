package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Screens")
@Getter
@Setter
public class Screens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;
    private String name;
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "theaterId", referencedColumnName = "TheaterId")
    private Theaters theaters;
}
