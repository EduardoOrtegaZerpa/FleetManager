package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;

import java.util.List;

public interface IDrivingSchoolQueriesRepository {
    List<DrivingSchool> getDrivingSchools();
}
