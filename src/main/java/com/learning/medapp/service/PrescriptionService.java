package com.learning.medapp.service;

import com.learning.medapp.model.Prescription;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> getAllPrescription();
    Prescription addPrescription(Prescription prescription);
}
