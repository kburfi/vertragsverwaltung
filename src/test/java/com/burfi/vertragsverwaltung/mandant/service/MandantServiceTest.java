package com.burfi.vertragsverwaltung.mandant.service;

import com.burfi.vertragsverwaltung.common.exception.ExceptionWithStatus;
import com.burfi.vertragsverwaltung.mandant.repository.Mandant;
import com.burfi.vertragsverwaltung.mandant.repository.MandantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MandantServiceTest {

    @Mock
    private MandantRepository mandantRepository;

    @Mock
    private MandantMapper mandantMapper;

    @InjectMocks
    private MandantService mandantService;

    @Test
    void getById() {
        var testId = UUID.randomUUID();
        Mockito.when(mandantRepository.findById(testId)).thenReturn(Optional.of(new Mandant()));
        mandantService.getById(testId);
        Mockito.verify(mandantRepository).findById(testId);
        Mockito.verify(mandantMapper).mapToDto(Mockito.any());
    }

    @Test
    void getByIdThrowsException() {
        var testId = UUID.randomUUID();
        var exception = assertThrows(ExceptionWithStatus.class, () -> mandantService.getById(testId));
        Mockito.verify(mandantRepository).findById(testId);
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}