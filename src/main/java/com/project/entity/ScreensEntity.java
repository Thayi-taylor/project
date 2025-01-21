package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Screens")
public class ScreensEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreenID")
    private Integer screenId;

    @ManyToOne
    @JoinColumn(name = "TheaterID", nullable = false)
    private TheatersEntity theater;

    @Column(name = "ScreenName", nullable = false)
    private String screenName;

    @Column(name = "TotalSeats", nullable = false)
    private Integer totalSeats;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeatsEntity> seats;
}
