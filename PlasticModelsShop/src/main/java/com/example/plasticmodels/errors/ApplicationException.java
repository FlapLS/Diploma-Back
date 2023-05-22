package com.example.plasticmodels.errors;

import com.example.plasticmodels.errors.ApplicationError;
import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
    private ApplicationError applicationError;

    public ApplicationException(ApplicationError applicationError) {
        super(applicationError.getMessage());
        this.applicationError = applicationError;
    }
}
