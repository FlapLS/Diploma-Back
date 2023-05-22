package com.example.plasticmodels.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryPriceDto {
    private Long id;
    private LocalDateTime updateDate;
    private Integer price;
    private Long shopId;
}
