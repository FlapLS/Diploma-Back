package ru.authservice.application.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.authservice.application.auth.entities.dto.WorkerWithIdDTO;
import ru.authservice.application.auth.model.AuthDto;
import ru.authservice.application.auth.model.CustomerDto;
import ru.authservice.application.auth.model.TokenDto;
import ru.authservice.application.auth.service.AuthService;
import ru.authservice.application.common.Endpoints;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(Endpoints.LOGIN)
    public TokenDto authorization(@RequestBody AuthDto authDto) {
        return authService.authorization(authDto);
    }

    @PostMapping(Endpoints.LOGOUT)
    public void logout(@RequestBody TokenDto tokenDto) {
        authService.logout(tokenDto.getAuthToken());
    }

    @GetMapping(Endpoints.CUSTOMER_LOGIN_NOW)
    public Boolean loginNow() {
        return authService.loginNow();
    }

    @GetMapping(Endpoints.CUSTOMER_INFO)
    public CustomerDto getCustomerInfo(@PathVariable Long customerId) {
        return authService.getCustomerInfo(customerId);
    }

    @GetMapping(value = "/workers/{id}")
    public ResponseEntity<Object> getWorker(@PathVariable Integer id) {
        return ResponseEntity.ok(new WorkerWithIdDTO());
    }
}
