package com.abc.app.eh;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionController {

    @ExceptionHandler(value = PatientNotFoundException.class)
    public ResponseEntity exception(PatientNotFoundException exception) {
        return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PatientNotUpdatedException.class)
    public ResponseEntity exception(PatientNotUpdatedException exception){
        return new ResponseEntity("Patient id is not present or Patient not found", HttpStatus.NOT_FOUND);
    }
}
