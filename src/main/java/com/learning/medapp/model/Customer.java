package com.learning.medapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
}
