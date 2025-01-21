package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "discounts")
@Getter
@Setter
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;

    private String description;
    private int discountRate;
    private LocalTime discountStartTime;
    private LocalTime discountEndTime;
}
