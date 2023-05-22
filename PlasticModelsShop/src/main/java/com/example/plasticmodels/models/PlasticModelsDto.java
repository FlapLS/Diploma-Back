package com.example.plasticmodels.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlasticModelsDto {
    private Long id;
    private String name;
    private Type type;
    private Company company;
    private Integer amount;
    private LocalDateTime creationDate;
}
