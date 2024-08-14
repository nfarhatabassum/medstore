package com.learning.medapp.repository;

import com.learning.medapp.model.Customer;
import com.learning.medapp.model.Prescription;
import com.learning.medapp.model.Tablet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class PrescriptionRepoTest {
    @Autowired
    private PrescriptionRepo repo;

    private Prescription prescription;
    @BeforeEach
    public void setUp(){
        prescription = new Prescription(102, Arrays.asList(
                new Tablet[]{
                        new Tablet("Advent", "ABC")
                }), new Customer(2,"Anne","Anne@gmail.com")
        ,1500);
    }
    @Test
    public void givenPrescriptionIdReturnOptional(){
        final Optional<Prescription> prescriptionOptional = this.repo.findById(102);
        assertTrue(prescriptionOptional.isPresent(),"Prescription Object is null");
        String tabletName = prescriptionOptional.get().getTabletList().get(0).getTableName();
        assertEquals("Dolo",tabletName,"Table name not matching");
    }
}
