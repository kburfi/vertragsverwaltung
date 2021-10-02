package com.burfi.vertragsverwaltung.mandant.service;

import com.burfi.vertragsverwaltung.common.exception.ExceptionWithStatus;
import com.burfi.vertragsverwaltung.mandant.dto.MandantDto;
import com.burfi.vertragsverwaltung.mandant.dto.SaveMandantDto;
import com.burfi.vertragsverwaltung.mandant.repository.Mandant;
import com.burfi.vertragsverwaltung.mandant.repository.MandantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MandantService {

    private final MandantRepository mandantRepository;
    private final MandantMapper mandantMapper;

    public MandantDto getById(final UUID uuid) {
        var mandant = getMandant(uuid);
        return mandantMapper.mapToDto(mandant);
    }

    public Mandant getMandant(final UUID uuid) {
        var mandant = mandantRepository.findById(uuid);
        if (mandant.isEmpty()) {
            throw new ExceptionWithStatus("No such mandant", HttpStatus.NOT_FOUND);
        }
        return mandant.get();
    }

    public MandantDto saveMandant(final SaveMandantDto saveMandantDto) {
        if (saveMandantDto.getId() != null) {
            throw new ExceptionWithStatus("New mandant cannot have id", HttpStatus.BAD_REQUEST);
        }
        var mandant = mandantMapper.mapToEntity(saveMandantDto);
        var savedMandant = mandantRepository.save(mandant);
        return mandantMapper.mapToDto(savedMandant);
    }

    @Transactional
    public MandantDto updateMandant(final SaveMandantDto saveMandantDto) {
        var existingMandant = loadExistingMandant(saveMandantDto);
        existingMandant.setName(saveMandantDto.getName());
        existingMandant.setLogo(saveMandantDto.getLogo());
        existingMandant = mandantRepository.save(existingMandant);
        return mandantMapper.mapToDto(existingMandant);
    }

    @Transactional
    public void delete(final UUID id) {
        var mandant = getMandant(id);
        mandantRepository.delete(mandant);
    }

    private Mandant loadExistingMandant(final SaveMandantDto saveMandantDto) {
        if (saveMandantDto.getId() == null) {
            throw new ExceptionWithStatus("To update mandant an id is required", HttpStatus.BAD_REQUEST);
        }
        var existing = mandantRepository.findById(saveMandantDto.getId());
        if (existing.isEmpty()) {
            throw new ExceptionWithStatus("Mandant with given id not found", HttpStatus.NOT_FOUND);
        }
        return existing.get();
    }
}
