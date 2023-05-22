package com.example.shopservice.common;

import com.example.shopservice.errors.ApplicationError;
import com.example.shopservice.errors.ApplicationException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ApplicationError handleApplicationException(ApplicationException exception, HttpServletResponse response){
        response.setStatus(exception.getApplicationError().getStatus().value());
        log.debug("Exception happened {}", exception.getMessage());
        return exception.getApplicationError();
    }
}
