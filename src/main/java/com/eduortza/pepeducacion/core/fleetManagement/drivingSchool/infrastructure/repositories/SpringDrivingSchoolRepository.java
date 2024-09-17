package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.repositories;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.models.DrivingSchoolModel;
import com.eduortza.pepeducacion.core.shared.infrastructure.JPASpringRepository;
import com.eduortza.pepeducacion.core.shared.infrastructure.SpringRepository;


public class SpringDrivingSchoolRepository extends SpringRepository<DrivingSchool> implements IDrivingSchoolRepository {

    public SpringDrivingSchoolRepository(JPASpringRepository<DrivingSchoolModel> repository) {
        super(repository);
    }
}
