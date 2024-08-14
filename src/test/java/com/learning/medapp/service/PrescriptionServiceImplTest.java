package com.learning.medapp.service;

import com.learning.medapp.model.Customer;
import com.learning.medapp.model.Prescription;
import com.learning.medapp.repository.PrescriptionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PrescriptionServiceImplTest {

    @Mock
    private PrescriptionRepo prescriptionRepo;

    @InjectMocks
    private PrescriptionServiceImpl prescriptionService;
    private Prescription prescription;
    private List<Prescription> prescriptionList;

    @BeforeEach
    public void setUp(){
        prescriptionList = new ArrayList<>();
        prescriptionList.add(new Prescription(101,new Customer(1,"Smith","Smith@gmail.com"),1000));
        prescriptionList.add(new Prescription(102,new Customer(2,"Anne","Anne@gmail.com"),1000));
        prescriptionList.add(new Prescription(103,new Customer(3,"James","James@gmail.com"),1000));
        prescriptionList.add(new Prescription(104,new Customer(4,"John","Johm@gmail.com"),1000));
        prescriptionList.add(new Prescription(105,new Customer(5,"Rahul","Rahul@gmail.com"),1000));
    }

    @Test
    public void getAllPrescriptionExistsThenReturnCustomerDetails(){
        when(prescriptionRepo.findAll()).thenReturn(prescriptionList);
        List<Prescription> prescriptions = prescriptionService.getAllPrescription();
        int records = prescriptions.size();
        Assertions.assertEquals(5,records,"Number of records did not match");
        String customerName = prescriptions.get(2).getCustomer().getCustomerName();
        assertEquals("Customer Name is not matching","James",customerName);
        verify(prescriptionRepo,times(2)).findAll();
    }
}
