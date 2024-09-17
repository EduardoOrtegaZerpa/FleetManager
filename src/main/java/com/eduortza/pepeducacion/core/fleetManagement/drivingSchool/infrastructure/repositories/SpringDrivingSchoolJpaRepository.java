package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.repositories;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.models.DrivingSchoolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SpringDrivingSchoolJpaRepository extends JpaRepository<DrivingSchoolModel, UUID> {
    // JpaRepository provides built-in CRUD methods.
}
