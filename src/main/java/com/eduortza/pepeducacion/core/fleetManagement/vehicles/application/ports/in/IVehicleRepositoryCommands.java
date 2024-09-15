package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import com.eduortza.pepeducacion.core.shared.domain.Plate;

public interface IVehicleRepositoryCommands {
    void buyVehicle(CIF drivingSchoolId, Vehicle vehicle);
    void associateTeacherToVehicle(CIF drivingSchoolId, Plate vehicleId, DNI teacherId);
}
