package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.eduortza.pepeducacion.core.shared.domain.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface JPASpringRepository<T extends Entity> extends JpaRepository<T, UUID> {
    List<T> findAllByActiveTrue(); // Para obtener solo las entidades activas
}
