package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;

import java.util.List;

public interface IDrivingSchoolRepositoryQueries {
    List<DrivingSchool> getDrivingSchools();
}
