package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.queries;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.application.IQuery;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.List;

public class FindAllVehiclesQuery implements IQuery<Void, List<Vehicle>> {
    private final IVehiclesRepository repository;

    public FindAllVehiclesQuery(IVehiclesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<Vehicle>> query(Void params) {
        return Result.success(repository.findAll());
    }
}
