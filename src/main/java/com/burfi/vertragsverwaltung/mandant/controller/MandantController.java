package com.burfi.vertragsverwaltung.mandant.controller;

import com.burfi.vertragsverwaltung.common.Paths;
import com.burfi.vertragsverwaltung.mandant.dto.MandantDto;
import com.burfi.vertragsverwaltung.mandant.dto.SaveMandantDto;
import com.burfi.vertragsverwaltung.mandant.service.MandantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Paths.MANDANT)
@RequiredArgsConstructor
public class MandantController {

    private final MandantService mandantService;

    @GetMapping("/{id}")
    public ResponseEntity<MandantDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(mandantService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MandantDto> saveMandant(@RequestBody SaveMandantDto saveMandantDto) {
        return ResponseEntity.ok(mandantService.saveMandant(saveMandantDto));
    }

    @PutMapping
    public ResponseEntity<MandantDto> updateMandant(@RequestBody SaveMandantDto saveMandantDto) {
        return ResponseEntity.ok(mandantService.updateMandant(saveMandantDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMandant(@PathVariable UUID id) {
        mandantService.delete(id);
        return ResponseEntity.ok().build();
    }

}
