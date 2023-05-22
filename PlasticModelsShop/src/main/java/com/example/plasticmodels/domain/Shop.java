package com.example.plasticmodels.domain;

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
    private Integer price;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @JoinColumn(table = "plastic_models",name = "id",nullable = false,updatable = true,insertable = true)
    @Column
    private Long plasticModelId;

}
