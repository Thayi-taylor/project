package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Schedules")
@Getter
@Setter
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    @ManyToOne
    @JoinColumn(name = "screenId", referencedColumnName = "ScreenId")
    private Screens screens;

    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "MovieID")
    private Movies movies;

    private LocalDate MovieShowDate;
    private LocalTime MovieStartTime;
    private int MovieDuration;
    private LocalTime MovieEndTime;
}