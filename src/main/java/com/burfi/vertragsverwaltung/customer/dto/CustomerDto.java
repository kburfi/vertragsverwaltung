package com.burfi.vertragsverwaltung.customer.dto;

import com.burfi.vertragsverwaltung.mandant.dto.MandantDto;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CustomerDto {

    private UUID id;
    private Long customerNumber;
    private String name;
    private MandantDto mandant;

}
