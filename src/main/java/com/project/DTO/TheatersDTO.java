package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TheatersDTO {
    private int TheaterId;
    private String TheaterName;
    private String Location;
    private String ContactInfo;

}
