package com.project.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomersDTO {
    private int CustomerIndex;
    private String CustomerId;
    private String CustomerPw;
    private String CustomerName;
    private String CustomerContact;
    private String CustomerEmail;
}
