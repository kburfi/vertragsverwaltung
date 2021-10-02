package com.burfi.vertragsverwaltung.customer.controller;

import com.burfi.vertragsverwaltung.common.Paths;
import com.burfi.vertragsverwaltung.customer.dto.CreateCustomerDto;
import com.burfi.vertragsverwaltung.customer.service.CustomerService;
import com.burfi.vertragsverwaltung.customer.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(Paths.CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getByid(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @GetMapping("/from/mandant/{mandantId}")
    public ResponseEntity<List<CustomerDto>> getAllByMandant(@PathVariable("mandantId") UUID mandantId) {
        return ResponseEntity.ok(customerService.getAllByMandant(mandantId));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        return ResponseEntity.ok(customerService.createCustomer(createCustomerDto));
    }
}
