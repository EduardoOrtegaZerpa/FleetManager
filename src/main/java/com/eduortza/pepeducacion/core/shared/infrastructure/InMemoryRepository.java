package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.eduortza.pepeducacion.core.shared.application.IRepository;
import com.eduortza.pepeducacion.core.shared.domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private final List<T> entities = new ArrayList<>();

    @Override
    public void save(T entity) {
        // Check if an entity with the same ID already exists
        Optional<T> existingEntity = findById(entity.getId());
        // If it exists, remove it and add the updated entity
        existingEntity.ifPresent(entities::remove);
        // Add the entity (whether new or updated)
        entities.add(entity);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id) && entity.isActive())
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        // Return only active entities
        return new ArrayList<>(entities.stream()
                .filter(Entity::isActive)
                .toList());
    }

    @Override
    public void deleteById(UUID id) {
        entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .ifPresent(entity -> entity.setActive(false)); // Soft delete: mark as inactive
    }

    @Override
    public boolean existsById(UUID id) {
        // Check if there is an active entity with the given id
        return entities.stream()
                .anyMatch(entity -> entity.getId().equals(id) && entity.isActive());
    }

    @Override
    public T update(T entity, UUID id) {
        Optional<T> existingEntity = findById(id);
        if (existingEntity.isPresent()) {
            entities.remove(existingEntity.get()); // Remove the old entity
            entities.add(entity); // Add the updated entity
            return entity;
        }
        return null;
    }
}
