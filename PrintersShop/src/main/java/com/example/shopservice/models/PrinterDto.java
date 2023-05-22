package com.example.shopservice.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class PrinterDto {
    private Long id;
    private String name;
    private Company company;
    private LocalDateTime creationDate;
    private Type type;
    private String photo;
    private Integer amount;
    List<Long> shops;

}
