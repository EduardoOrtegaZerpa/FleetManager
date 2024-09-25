package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.UUID;

public class AssociateVehicleCommand implements ICommand<AssociateVehicleDTO, Void> {
    private final IVehiclesRepository repository;
    private final IEventBus bus;

    public AssociateVehicleCommand(IVehiclesRepository repository, IEventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Result<Void> run(AssociateVehicleDTO request) {
        try{
            UUID teacherId = UUID.fromString(request.teacherId());
            UUID vehicleId = UUID.fromString(request.vehicleId());
            //FIXME: Check if UUID is valid or not
            var optionalVehicle = repository.findById(vehicleId);
            if (optionalVehicle.isEmpty()) return Result.failure("Vehicle not found.");
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setTeacher(teacherId);
            this.repository.save(vehicle);
            this.bus.publish(vehicle.pullDomainEvents());
            return Result.success(null);
        } catch (Exception exception) {
            return Result.failure(exception.getMessage());
        }
    }
}
