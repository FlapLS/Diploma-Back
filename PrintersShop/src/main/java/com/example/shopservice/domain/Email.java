package com.example.shopservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Email {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private Integer price;

    @JoinColumn(table = "printer",name = "printerId",nullable = false,updatable = true,insertable = true)
    @Column
    private Long printerId;
}
