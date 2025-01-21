package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SeatsGrade")
@Getter
@Setter
public class SeatsGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GradeId;

    @ManyToOne
    @JoinColumn(name = "SeatId", referencedColumnName = "SeatId")
    private Seats seats;

    private int SeatPrice;


}
