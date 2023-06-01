package ru.authservice.application.auth.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import ru.authservice.application.auth.service.AuthService;
import ru.authservice.application.auth.domain.Customer;
import ru.authservice.application.auth.domain.CustomerRepository;
import ru.authservice.application.auth.domain.Token;
import ru.authservice.application.auth.domain.TokenRepository;
import ru.authservice.application.auth.mapper.Mapper;
import ru.authservice.application.auth.model.AuthDto;
import ru.authservice.application.auth.model.CustomerDto;
import ru.authservice.application.auth.model.TokenDto;
import ru.authservice.error.ErrorDescriptor;
import ru.authservice.utils.JwtUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenRepository tokenRepository;

    private final CustomerRepository customerRepository;

    private final JwtUtils jwtUtils;

    private final Mapper mapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void logout(String accessToken) {
        ErrorDescriptor.USER_TOKEN_ACCESS_NOT_FOUND.throwIsFalse(tokenRepository.existsByToken(accessToken));
        tokenRepository.delete(tokenRepository.getByToken(accessToken)
                .orElseThrow(ErrorDescriptor.USER_LOGOUT_LAST::throwApplication));
    }

    @Override
    public TokenDto authorization(AuthDto authDto) {
        ErrorDescriptor.USER_AUTH_PROBLEM.throwIsFalse(customerRepository.existsByLogin(authDto.getLogin()));
        Customer customer = customerRepository.getCustomerByLogin(authDto.getLogin())
                .orElseThrow(ErrorDescriptor.USER_AUTH_PROBLEM::throwApplication);
        ErrorDescriptor.USER_AUTH_PROBLEM.throwIsFalse(passwordEncoder.matches(authDto.getPassword(),
                customer.getPassword()));
        Optional<Token> checkLogin = tokenRepository.getByCustomer(customer);
        Token token = new Token();
        if(checkLogin.isPresent()){
            token = checkLogin.get();
        }
        token.setToken(jwtUtils.generateToken(mapper.convertToCustomerDto(customer)));
        token.setCustomer(customer);
        tokenRepository.save(token);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setAuthToken(token.getToken());
        tokenDto.setRole(customer.getRole());
        return tokenDto;
    }

    @Override
    public Boolean loginNow() {
        CustomerDto customerDto = (CustomerDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !ObjectUtils.isEmpty(customerDto) && checkCustomerLogin(customerDto);
    }

    @Override
    public CustomerDto getCustomerInfo(Long customerId) {
        return mapper.convertToCustomerDto(customerRepository.getById(customerId));
    }

    private Boolean checkCustomerLogin(CustomerDto customerDto){
        Customer customer = customerRepository.getCustomerByLogin(customerDto.getLogin())
                .orElseThrow(ErrorDescriptor.USER_AUTH_PROBLEM::throwApplication);
        return customer.getToken().size() >= 1;
    }
}
