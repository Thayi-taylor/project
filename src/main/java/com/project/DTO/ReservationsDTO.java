package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservationsDTO {
    private int ReservationId;
    private int TotalPrice;
    private LocalDate ReservationDate;
}
