package ru.authservice.application.auth.model;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String login;
    private Role role;
}
