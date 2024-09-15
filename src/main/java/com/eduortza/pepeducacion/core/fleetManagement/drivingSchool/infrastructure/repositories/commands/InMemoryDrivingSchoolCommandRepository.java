package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.repositories.commands;


import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolCommandsRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDrivingSchoolCommandRepository implements IDrivingSchoolCommandsRepository {

    private final List<DrivingSchool> drivingSchools = new ArrayList<>();

    @Override
    public void addDrivingSchool(DrivingSchool drivingSchool) {
        drivingSchools.add(drivingSchool);
    }

    @Override
    public void openSection(CIF drivingSchoolId, Section section) {
        Optional<DrivingSchool> schoolOpt = drivingSchools.stream()
                .filter(s -> s.getCIF().equals(drivingSchoolId))
                .findFirst();

        schoolOpt.ifPresent(drivingSchool -> drivingSchool.addSection(section));
    }

    @Override
    public void updateFiscalData(CIF drivingSchoolId, CIF fiscalData) {
        drivingSchools.stream()
                .filter(school -> school.getCIF().equals(drivingSchoolId))
                .forEach(school -> school.setCIF(fiscalData));
    }
}
