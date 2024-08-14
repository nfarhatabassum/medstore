package com.learning.medapp.service;

import com.learning.medapp.model.Prescription;
import com.learning.medapp.repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    private PrescriptionRepo repository;

    @Override
    public List<Prescription> getAllPrescription() {
        return repository.findAll();
    }

    @Override
    public Prescription addPrescription(Prescription prescription) {
        return repository.save(prescription);
    }
}
