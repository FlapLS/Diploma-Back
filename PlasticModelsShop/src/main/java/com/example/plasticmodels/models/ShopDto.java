package com.example.plasticmodels.models;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShopDto {
    private Long shopId;
    private String name;
    private String url;
    private Integer price;
    private Long plasticModelId;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
