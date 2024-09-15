package com.eduortza.pepeducacion.core.shared.application;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepository<T> {
    void save(T entity);
    Optional<T> findById(UUID id);
    List<T> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);
    T update(T entity, UUID id);
}
