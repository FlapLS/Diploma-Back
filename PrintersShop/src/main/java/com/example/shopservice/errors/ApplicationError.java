package com.example.shopservice.errors;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationError {
    private String message;
    //private String time;
    private HttpStatus status;


}
