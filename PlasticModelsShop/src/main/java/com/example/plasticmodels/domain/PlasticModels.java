package com.example.plasticmodels.domain;

import com.example.plasticmodels.models.Company;
import com.example.plasticmodels.models.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class PlasticModels {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private LocalDateTime creationDate;

    @Column
    @Enumerated(EnumType.STRING)
    private Company company;

    @Column
    private Integer amount;
}
