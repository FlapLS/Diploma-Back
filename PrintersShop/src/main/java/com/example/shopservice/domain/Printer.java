package com.example.shopservice.domain;

import com.example.shopservice.models.Company;
import com.example.shopservice.models.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Printer {

    @Id
    @GeneratedValue
    private Long printerId;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    @Enumerated(EnumType.STRING)
    private Company company;

    private Long price;
    @Column
    private LocalDateTime creationDate;

    @Column
    private String photo;

    @Column
    private Integer amount;

}
