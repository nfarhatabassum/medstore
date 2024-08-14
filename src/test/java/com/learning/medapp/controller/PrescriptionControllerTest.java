package com.learning.medapp.controller;






import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.medapp.contoller.PrescriptionController;
import com.learning.medapp.model.Customer;
import com.learning.medapp.model.Prescription;
import com.learning.medapp.model.Tablet;
import com.learning.medapp.service.PrescriptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PrescriptionController.class)
public class PrescriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrescriptionServiceImpl service;

    private Prescription prescription;
    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp(){
        prescription = new Prescription(102, Arrays.asList(
                new Tablet[]{
                        new Tablet("Advent", "ABC")
                }), new Customer(2,"Anne","Anne@gmail.com")
                ,1500);
    }
    @Test
    public void addPrescriptionThenReturnCreatedStatus() throws Exception {
        when(service.addPrescription(any(Prescription.class))).thenReturn(prescription);
        mockMvc.perform(
                        post("/addPrescription")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(prescription)))
                .andExpect(status().isCreated());

    }




}
