package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Seats", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ScreenID", "RowNumber", "SeatNumber"})
})
public class SeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID")
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "ScreenID", nullable = false)
    private ScreensEntity screen;

    @Column(name = "RowNumber", nullable = false)
    private String rowNumber;

    @Column(name = "SeatNumber", nullable = false)
    private Integer seatNumber;
}
