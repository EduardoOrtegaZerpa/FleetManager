package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.repositories.queries;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolQueriesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDrivingSchoolQueryRepository implements IDrivingSchoolQueriesRepository {

    private final List<DrivingSchool> drivingSchools = new ArrayList<>();

    @Override
    public List<DrivingSchool> getDrivingSchools() {
        return new ArrayList<>(drivingSchools);
    }
}