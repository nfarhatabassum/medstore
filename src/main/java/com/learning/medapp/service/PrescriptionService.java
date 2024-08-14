package com.learning.medapp.service;

import java.util.List;

public interface PrescriptionService {
    List<PrescriptionService> getAllPrescription();
    PrescriptionService addPrescription(PrescriptionService prescription);
}
