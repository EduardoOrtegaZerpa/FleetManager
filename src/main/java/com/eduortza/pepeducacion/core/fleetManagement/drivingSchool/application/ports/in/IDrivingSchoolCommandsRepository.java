package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;

public interface IDrivingSchoolCommandsRepository {
    void addDrivingSchool(DrivingSchool drivingSchool);
    void openSection(CIF drivingSchoolId, Section section);
    void updateFiscalData(CIF drivingSchoolId, CIF fiscalData);
}
