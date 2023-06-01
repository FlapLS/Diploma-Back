package ru.authservice.application.auth.mapper;

import org.springframework.stereotype.Component;
import ru.authservice.application.auth.domain.Customer;
import ru.authservice.application.auth.model.CustomerDto;

@Component
public class Mapper {
    public CustomerDto convertToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setLogin(customer.getLogin());
        customerDto.setRole(customer.getRole());
        return customerDto;
    }
}
