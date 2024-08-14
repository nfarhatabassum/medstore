package com.learning.medapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Prescription {
    @Id
    private int prescriptionId;
    private List<Tablet> tabletList;
    private Customer customer;
    private double totalPrice;

    public Prescription(int prescriptionId, Customer customer, double totalPrice) {
        this.prescriptionId = prescriptionId;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }
}
