package ru.authservice.application.auth.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.authservice.application.auth.model.AuthDto;
import ru.authservice.application.auth.model.CustomerDto;
import ru.authservice.application.auth.model.TokenDto;

public interface AuthService {

    void logout(String accessToken);

    TokenDto authorization(AuthDto authDto);

    Boolean loginNow();

    CustomerDto getCustomerInfo(Long customerId);

}
