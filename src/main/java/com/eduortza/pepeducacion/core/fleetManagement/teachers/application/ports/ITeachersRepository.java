package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.application.IRepository;

public interface ITeachersRepository extends IRepository<Teacher> {
    boolean checkIfDrivingSchoolExists(String drivingSchoolId);
}
