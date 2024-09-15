package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.queries;


import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.shared.application.IQuery;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import javax.management.Query;
import java.util.List;

public class GetDrivingSchoolsQuery implements IQuery<Void, List<DrivingSchool>> {
    private final IDrivingSchoolRepository drivingSchoolRepo;

    public GetDrivingSchoolsQuery(IDrivingSchoolRepository drivingSchoolRepo) {
        this.drivingSchoolRepo = drivingSchoolRepo;
    }

    public List<DrivingSchool> execute() {
    }

    @Override
    public Result<Void> query(List<DrivingSchool> params) {
        return Result.success(drivingSchoolRepo.findAll());
    }
}
