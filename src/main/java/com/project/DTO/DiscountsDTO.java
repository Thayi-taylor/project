package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class DiscountsDTO {
    private int DiscountId;
    private String Description;
    private int DiscountRate;
    private LocalTime DiscountStartTime;
    private LocalTime DiscountEndTime;

}
