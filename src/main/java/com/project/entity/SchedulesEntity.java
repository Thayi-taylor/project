package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "Schedules")
public class SchedulesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScheduleID")
    private Integer scheduleId;

    @ManyToOne
    @JoinColumn(name = "ScreenID", nullable = false)
    private ScreensEntity screen;

    @ManyToOne
    @JoinColumn(name = "MovieID", nullable = false)
    private MoviesEntity movie;

    @Column(name = "MovieShowDate", nullable = false)
    private LocalDate movieShowDate;

    @Column(name = "MovieStartTime", nullable = false)
    private LocalTime movieStartTime;

    @Column(name = "MovieDuration", nullable = false)
    private Integer movieDuration;
}
