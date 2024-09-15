package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;
import com.eduortza.pepeducacion.core.shared.application.ICommand;

public class OpenSectionCommand {
    private final IDrivingSchoolRepository repository;

    public OpenSectionCommand(IDrivingSchoolRepository drivingSchoolRepo) {
        this.repository = drivingSchoolRepo;
    }

    public void execute(CIF drivingSchoolId, Section section) {
    }
}