package com.Pixmonks.InstituteStudentManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public  ResourceNotFoundException(String message){
        super(message);
    }
}