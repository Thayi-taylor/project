package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeatsDTO {
    private int seatId;
    private String rowNumber;
    private int seatNumber;
    private String status; // Available or Reserved
}