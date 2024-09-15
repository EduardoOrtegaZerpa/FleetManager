package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.queries;


import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolQueriesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;

import java.util.List;

public class GetDrivingSchoolsQuery {
    private final IDrivingSchoolQueriesRepository drivingSchoolRepo;

    public GetDrivingSchoolsQuery(IDrivingSchoolQueriesRepository drivingSchoolRepo) {
        this.drivingSchoolRepo = drivingSchoolRepo;
    }

    public List<DrivingSchool> execute() {
        return drivingSchoolRepo.getDrivingSchools();
    }
}
