package com.example.shopservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table
@Getter
@Setter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @Column
    private Integer price;

    @JoinColumn(table = "printer",name = "printer_id",nullable = false,updatable = true,insertable = true)
    @Column
    private Long printerId;


}
