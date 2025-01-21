package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Screens")
@Getter
@Setter
public class ScreensEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "screenId")
    private int screenId;

    private String ScreenName;
    private int totalSeats;

    @OneToMany(mappedBy = "screens", cascade = CascadeType.ALL)
    private List<SeatsEntity> seatsEntityList;
}
