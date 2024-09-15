package com.eduortza.pepeducacion.core.fleetManagement.teachers.infrastructure;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.infrastructure.InMemoryRepository;

public class InMemoryTeachersRepository extends InMemoryRepository<Teacher> implements ITeachersRepository {
    @Override
    public boolean checkIfDrivingSchoolExists(String drivingSchoolId) {
        return false;
    }
}
