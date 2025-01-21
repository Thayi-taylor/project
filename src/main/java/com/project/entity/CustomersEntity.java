package com.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Getter
@Setter
public class CustomersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerIndex;

    private String customerId;
    private String customerPw;
    private String customerName;
    private String customerContact;
    private String customerEmail;
}
