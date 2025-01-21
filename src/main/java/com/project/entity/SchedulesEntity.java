package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Schedules")
@Getter
@Setter
public class SchedulesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    @ManyToOne
    @JoinColumn(name = "screenId", referencedColumnName = "screenId", nullable = false) // 명시적 컬럼 매핑
    private ScreensEntity scheduledScreen;

    private int movieId;
    private String showDate;
    private String startTime;
}
