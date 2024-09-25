package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.queries;


import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.shared.application.IQuery;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import javax.management.Query;
import java.util.List;

public class GetDrivingSchoolsQuery implements IQuery<Void, List<DrivingSchool>> {
    private final IDrivingSchoolRepository repository;

    public GetDrivingSchoolsQuery(IDrivingSchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<DrivingSchool>> query(Void params) {
        return Result.success(repository.findAll().stream().toList());
    }
}
