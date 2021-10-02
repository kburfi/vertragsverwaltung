package com.burfi.vertragsverwaltung.mandant.service;

import com.burfi.vertragsverwaltung.mandant.dto.MandantDto;
import com.burfi.vertragsverwaltung.mandant.dto.SaveMandantDto;
import com.burfi.vertragsverwaltung.mandant.repository.Mandant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MandantMapper {

    MandantDto mapToDto(Mandant entity);

    Mandant mapToEntity(SaveMandantDto saveMandantDto);
}
