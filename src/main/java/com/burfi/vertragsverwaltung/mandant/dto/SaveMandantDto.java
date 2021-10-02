package com.burfi.vertragsverwaltung.mandant.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class SaveMandantDto {

    private UUID id;

    private String name;

    private byte[] logo;
}
