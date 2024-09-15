package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;

import java.util.List;

public interface IVehicleRepositoryQueries {
    List<Vehicle> getVehicles();
}
