package com.example.shopservice.errors;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private ApplicationError applicationError;

    public ApplicationException(ApplicationError applicationError) {
        super(applicationError.getMessage());
        this.applicationError = applicationError;
    }
}
