package com.learning.medapp.repository;

import com.learning.medapp.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends MongoRepository<Prescription,Integer> {
}
