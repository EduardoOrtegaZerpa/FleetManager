package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolCommandsRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;


public class AddDrivingSchoolCommand {
    private final IDrivingSchoolCommandsRepository drivingSchoolRepo;

    public AddDrivingSchoolCommand(IDrivingSchoolCommandsRepository drivingSchoolRepo) {
        this.drivingSchoolRepo = drivingSchoolRepo;
    }

    public void execute(DrivingSchool drivingSchool) {
        drivingSchoolRepo.addDrivingSchool(drivingSchool);
    }
}