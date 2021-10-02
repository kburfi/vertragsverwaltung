package com.burfi.vertragsverwaltung.mandant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MandantRepository extends JpaRepository<Mandant, UUID> {
}
