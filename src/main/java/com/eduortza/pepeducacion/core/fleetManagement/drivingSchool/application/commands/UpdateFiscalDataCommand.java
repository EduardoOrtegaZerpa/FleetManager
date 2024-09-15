package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in.IDrivingSchoolCommandsRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;

public class UpdateFiscalDataCommand {
    private final IDrivingSchoolCommandsRepository drivingSchoolRepo;

    public UpdateFiscalDataCommand(IDrivingSchoolCommandsRepository drivingSchoolRepo) {
        this.drivingSchoolRepo = drivingSchoolRepo;
    }

    public void execute(CIF drivingSchoolId, CIF fiscalData) {
        drivingSchoolRepo.updateFiscalData(drivingSchoolId, fiscalData);
    }
}
