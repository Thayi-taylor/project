package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SeatsGrade")
public class SeatsGradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GradeID")
    private Integer gradeId;

    @OneToOne
    @JoinColumn(name = "SeatID", nullable = false, unique = true)
    private SeatsEntity seat;

    @Column(name = "SeatPrice", nullable = false)
    private Integer seatPrice;
}
