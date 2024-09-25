package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.mock;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.shared.infrastructure.InMemoryRepository;

public class InMemoryDrivingSchoolRepository extends InMemoryRepository<DrivingSchool> implements IDrivingSchoolRepository {
}
