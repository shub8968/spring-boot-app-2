package com.abc.app.controller;

import com.abc.app.model.Patient;
import com.abc.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {


    @Autowired
    AppService appService;

    @GetMapping("/get")
    public ResponseEntity getPatientById(@RequestParam("id") Long id) {
      Patient patient =  appService.getPatientById(id);
      ResponseEntity responseEntity = new ResponseEntity(patient, HttpStatus.OK);
      return responseEntity;
    }

    @GetMapping("/get/all")
    public ResponseEntity getPatient() {
        List<Patient> patient =  appService.getPatient();
        ResponseEntity responseEntity = new ResponseEntity(patient, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/put")
    public ResponseEntity updatePatient(@RequestBody Patient patient){
        appService.updatePatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatientById(@PathVariable("id")Long id){
        appService.getPatientById(id);
        appService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity createPatient(@RequestBody Patient patient){
        appService.createPatient(patient);
        return new ResponseEntity(HttpStatus.OK);
    }


}
