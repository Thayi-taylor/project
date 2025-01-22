package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeatsDTO {

    private Integer seatId;
    private String rowNumber;
    private Integer seatNumber;
    private String status; // Available or Reserved
}