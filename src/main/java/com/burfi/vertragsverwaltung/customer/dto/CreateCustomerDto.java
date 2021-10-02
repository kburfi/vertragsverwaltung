package com.burfi.vertragsverwaltung.customer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CreateCustomerDto {
    private String name;
    private UUID mandantId;
}
