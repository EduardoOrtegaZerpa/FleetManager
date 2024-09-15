package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolCommandsRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;

public class OpenSectionCommand {
    private final IDrivingSchoolCommandsRepository drivingSchoolRepo;

    public OpenSectionCommand(IDrivingSchoolCommandsRepository drivingSchoolRepo) {
        this.drivingSchoolRepo = drivingSchoolRepo;
    }

    public void execute(CIF drivingSchoolId, Section section) {
        drivingSchoolRepo.openSection(drivingSchoolId, section);
    }
}