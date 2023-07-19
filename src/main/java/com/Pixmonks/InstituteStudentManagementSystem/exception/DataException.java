package com.Pixmonks.InstituteStudentManagementSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataException {
    private String message;
    private int status;
}
