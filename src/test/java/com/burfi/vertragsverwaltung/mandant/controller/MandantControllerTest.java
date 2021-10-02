package com.burfi.vertragsverwaltung.mandant.controller;

import com.burfi.vertragsverwaltung.mandant.dto.SaveMandantDto;
import com.burfi.vertragsverwaltung.mandant.service.MandantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class MandantControllerTest {

    @Mock
    private MandantService mandantService;

    @InjectMocks
    private MandantController mandantController;

    @Test
    void getById() {
        var id = UUID.randomUUID();
        mandantController.getById(id);
        Mockito.verify(mandantService).getById(id);
    }

    @Test
    void saveMandant() {
        var dto = mockDto().build();
        mandantController.saveMandant(dto);
        Mockito.verify(mandantService).saveMandant(dto);
    }

    @Test
    void updateMandant() {
        var dto = mockDto().id(UUID.randomUUID()).build();
        mandantController.updateMandant(dto);
        Mockito.verify(mandantService).updateMandant(dto);
    }

    @Test
    void deleteMandant() {
        var id = UUID.randomUUID();
        mandantController.deleteMandant(id);
        Mockito.verify(mandantService).delete(id);
    }

    private SaveMandantDto.SaveMandantDtoBuilder mockDto() {
        return SaveMandantDto.builder().name("test");
    }
}