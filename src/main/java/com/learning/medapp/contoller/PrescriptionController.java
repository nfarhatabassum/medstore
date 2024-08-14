package com.learning.medapp.contoller;

import com.learning.medapp.model.Prescription;
import com.learning.medapp.service.PrescriptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrescriptionController {
    @Autowired
    private PrescriptionService service;
    ResponseEntity<?> responseEntity;
    @GetMapping("/prescriptions")
    public ResponseEntity<?> getAllPrescriptionData(){
        List<Prescription> prescriptionList = service.getAllPrescription();
        if(!prescriptionList.isEmpty()){
            responseEntity = new ResponseEntity<List<Prescription>>(prescriptionList, HttpStatus.ACCEPTED);
        }
        else{
            responseEntity = new ResponseEntity<String>("No Data Found",HttpStatus.BAD_REQUEST);
        }
        return  responseEntity;
    }
    @PostMapping("/addPrescription")
    public ResponseEntity<?> addPrescription(@RequestBody Prescription prescription){
        Prescription prescriptionObj =  service.addPrescription(prescription);
        if(prescriptionObj!=null){
            responseEntity = new ResponseEntity<String>("Prescription Object added Successfully",HttpStatus.CREATED);
        }
        else{
            responseEntity = new ResponseEntity<String>("Failure",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
