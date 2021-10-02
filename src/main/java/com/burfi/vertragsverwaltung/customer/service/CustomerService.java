package com.burfi.vertragsverwaltung.customer.service;

import com.burfi.vertragsverwaltung.common.exception.ExceptionWithStatus;
import com.burfi.vertragsverwaltung.customer.dto.CreateCustomerDto;
import com.burfi.vertragsverwaltung.customer.repository.Customer;
import com.burfi.vertragsverwaltung.customer.repository.CustomerRepository;
import com.burfi.vertragsverwaltung.customer.dto.CustomerDto;
import com.burfi.vertragsverwaltung.mandant.service.MandantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MandantService mandantService;
    private final CustomerMapper customerMapper;

    public CustomerDto getById(final UUID customerId) {
        var customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new ExceptionWithStatus("Customer could not be found by id", HttpStatus.NOT_FOUND);
        }
        return customerMapper.mapToDto(customer.get());
    }

    public List<CustomerDto> getAllByMandant(final UUID mandantId) {
        return customerRepository.findByMandantId(mandantId)
                .stream().map(customerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CustomerDto createCustomer(final CreateCustomerDto createCustomerDto) {
        var mandant = mandantService.getMandant(createCustomerDto.getMandantId());
        var customer = Customer.builder().name(createCustomerDto.getName()).mandant(mandant).build();
        customer = customerRepository.save(customer);
        return customerMapper.mapToDto(customer);
    }
}
