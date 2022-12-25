package com.demo.controller;

import com.demo.model.RedCarpet;
import com.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/record")
public class AppController {


    @Autowired
    AppService appService;

    @GetMapping("/get")
    public ResponseEntity getPatientById(@RequestParam("id") Long id) {
        RedCarpet redCarpet =  appService.getRecordById(id);
      ResponseEntity responseEntity = new ResponseEntity(redCarpet, HttpStatus.OK);
      return responseEntity;
    }

    @GetMapping("/get/all")
    public ResponseEntity getRecord() {
        Iterable<RedCarpet> listRecord =  appService.getRecord();
        ResponseEntity responseEntity = new ResponseEntity(listRecord, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/put")
    public ResponseEntity updateRecord(@RequestBody RedCarpet redCarpet){
        appService.updateRecord(redCarpet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRecordById(@PathVariable("id")Long id){
        appService.getRecordById(id);
        appService.deleteRecordById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity createRecord(@RequestBody RedCarpet redCarpet) {
        appService.createRecord(redCarpet);
        return new ResponseEntity(HttpStatus.OK);
    }


}
