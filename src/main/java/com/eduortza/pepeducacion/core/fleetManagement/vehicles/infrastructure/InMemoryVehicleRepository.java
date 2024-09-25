package com.eduortza.pepeducacion.core.fleetManagement.vehicles.infrastructure;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.infrastructure.InMemoryRepository;

public class InMemoryVehicleRepository extends InMemoryRepository<Vehicle> implements IVehiclesRepository {
}
