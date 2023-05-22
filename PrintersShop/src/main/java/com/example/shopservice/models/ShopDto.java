package com.example.shopservice.models;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopDto {
    private Long shopId;
    private String name;
    private String url;
    private Integer price;
    private String test;
    private Long printerId;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
