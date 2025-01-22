package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // ✅ 모든 필드를 포함하는 생성자 자동 생성
@NoArgsConstructor  // ✅ 기본 생성자 추가
public class SeatsDTO {
    private Integer seatId;
    private String rowNumber;
    private Integer seatNumber;
    private String status; // Available or Reserved
}