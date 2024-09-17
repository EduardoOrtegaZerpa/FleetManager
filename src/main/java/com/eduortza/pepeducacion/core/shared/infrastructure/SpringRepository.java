package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.eduortza.pepeducacion.core.shared.application.IRepository;
import com.eduortza.pepeducacion.core.shared.domain.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SpringRepository<T extends Entity> implements IRepository<T> {

    private final JPASpringRepository<T> repository;

    public SpringRepository(JPASpringRepository<T> repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        repository.save(entity);
    }

    public Optional<T> findById(UUID id) {
        return repository.findById(id)
                .filter(Entity::isActive);
    }

    public List<T> findAll() {
        return repository.findAllByActiveTrue();
    }

    public void deleteById(UUID id) {
        repository.findById(id)
                .ifPresent(entity -> {
                    entity.setActive(false);
                    repository.save(entity);
                });
    }

    public boolean existsById(UUID id) {
        return repository.existsById(id) && repository.findById(id).map(Entity::isActive).orElse(false);
    }

    public T update(T entity, UUID id) {
        Optional<T> existingEntity = findById(id);
        if (existingEntity.isPresent()) {
            repository.deleteById(id);
            return repository.save(entity);
        }
        return null;
    }
}
