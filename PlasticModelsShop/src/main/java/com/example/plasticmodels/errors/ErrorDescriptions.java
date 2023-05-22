package com.example.plasticmodels.errors;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ErrorDescriptions {
    NOT_FOUND("002", "Элемент не найден", HttpStatus.NOT_FOUND);

    private final String code;

    private final String message;

    private final HttpStatus status;


}
