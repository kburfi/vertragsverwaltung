package com.burfi.vertragsverwaltung.customer.service;

import com.burfi.vertragsverwaltung.customer.dto.CustomerDto;
import com.burfi.vertragsverwaltung.customer.repository.Customer;
import com.burfi.vertragsverwaltung.mandant.service.MandantMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MandantMapper.class})
public interface CustomerMapper {

    CustomerDto mapToDto(Customer customer);
}
