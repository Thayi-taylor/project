package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScreensDTO {
    private int ScreenId;
    private String ScreenName;
    private int TotalSeats;
}
