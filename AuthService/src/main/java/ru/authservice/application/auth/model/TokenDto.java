package ru.authservice.application.auth.model;

import lombok.Data;

@Data
public class TokenDto {

    private String authToken;

    private Role role;

}
