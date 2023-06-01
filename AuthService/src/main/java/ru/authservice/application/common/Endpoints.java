package ru.authservice.application.common;

public interface Endpoints {
    String LOGIN = "/login";
    String LOGOUT = "/logout";
    String CUSTOMER_LOGIN_NOW = "/login/customer";

    String CUSTOMER_INFO = "/customers/{customerId}";
}
