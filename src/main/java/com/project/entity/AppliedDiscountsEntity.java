package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appliedDiscounts")
@Getter
@Setter
public class AppliedDiscountsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appliedDiscountId;

    @ManyToOne
    @JoinColumn(name = "reservationId", referencedColumnName = "ReservationId")
    private ReservationsEntity reservations;

    @ManyToOne
    @JoinColumn(name = "discountId", referencedColumnName = "DiscountId")
    private DiscountsEntity discountsEntity;
}
