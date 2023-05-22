package com.example.shopservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class HistoryPrice {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDateTime updateDate;

    @Column
    private Integer price;

    @JoinColumn(table = "shop",name = "shopId",nullable = false,updatable = true,insertable = true)
    @Column
    private Long shopId;

}
