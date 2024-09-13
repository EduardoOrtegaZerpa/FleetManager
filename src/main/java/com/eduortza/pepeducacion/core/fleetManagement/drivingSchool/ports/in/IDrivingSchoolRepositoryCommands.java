package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;

import java.util.UUID;

public interface IDrivingSchoolRepositoryCommands {
    void addDrivingSchool(DrivingSchool drivingSchool);
    void openSection(CIF drivingSchoolId, Section section);
    void updateFiscalData(CIF drivingSchoolId, CIF fiscalData);
}
