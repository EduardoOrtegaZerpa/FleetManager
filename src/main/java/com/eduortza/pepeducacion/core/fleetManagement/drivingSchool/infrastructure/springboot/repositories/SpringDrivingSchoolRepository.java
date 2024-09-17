package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.repositories;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.mappers.DrivingSchoolMapper;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.DrivingSchoolModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Repository
public class SpringDrivingSchoolRepository implements IDrivingSchoolRepository {
    private final SpringDrivingSchoolJpaRepository repository;

    public SpringDrivingSchoolRepository(SpringDrivingSchoolJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(DrivingSchool entity) {
        this.repository.save(DrivingSchoolMapper.toModel(entity));
    }

    @Override
    public Optional<DrivingSchool> findById(UUID id) {
        return repository.findById(id).map(DrivingSchoolMapper::toDomain);
    }

    @Override
    public List<DrivingSchool> findAll() {
        return repository.findAll().stream()
                .map(DrivingSchoolMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public DrivingSchool update(DrivingSchool entity, UUID id) {
        Optional<DrivingSchoolModel> existingDrivingSchool = repository.findById(id);

        if (existingDrivingSchool.isPresent()) {
            DrivingSchoolModel updatedModel = DrivingSchoolMapper.toModel(entity);
            updatedModel.setId(id);  // Make sure the ID is maintained
            return DrivingSchoolMapper.toDomain(repository.save(updatedModel));
        }
        return null;  // Could throw an exception or handle the case where the entity doesn't exist
    }
}
