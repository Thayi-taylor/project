package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class SchedulesDTO {
    private int ScheduleId;
    private LocalDate MovieShowDate;
    private LocalTime MovieStartTime;
    private LocalTime MovieEndTime;
}
