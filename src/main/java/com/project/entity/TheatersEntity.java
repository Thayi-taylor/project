package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Theaters")
public class TheatersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TheaterID")
    private Integer theaterId;

    @Column(name = "TheaterName", nullable = false)
    private String theaterName;

    @Column(name = "Location", nullable = false)
    private String location;

    @Column(name = "ContactInfo")
    private String contactInfo;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScreensEntity> screens;
}
