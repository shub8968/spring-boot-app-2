package com.demo.eh;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecordExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity exception(RecordNotFoundException exception) {
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RecordNotUpdatedException.class)
    public ResponseEntity exception(RecordNotUpdatedException exception){
        return new ResponseEntity("Record id is not present or Record not found", HttpStatus.NOT_FOUND);
    }
}
