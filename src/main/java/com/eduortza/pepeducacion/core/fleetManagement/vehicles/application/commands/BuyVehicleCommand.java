package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.FuelType;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.ITV;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.Plate;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.UUID;

public class BuyVehicleCommand implements ICommand<BuyVehicleDTO, Vehicle> {
    private final IVehiclesRepository repository;
    private final IEventBus bus;

    public BuyVehicleCommand(IVehiclesRepository repository, IEventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Result<Vehicle> run(BuyVehicleDTO request){
        try {
            UUID drivingSchoolId = UUID.fromString(request.drivingSchoolId());
            //FIXME: Check if UUID is valid or not
            Plate plate = new Plate(request.plate());
            ITV itv = new ITV(request.lastInspectionDate(), request.nextInspectionDate());
            FuelType fuelType = new FuelType(request.fuelType());
            Vehicle vehicle = new Vehicle(
                plate,
                request.brand(),
                request.model(),
                itv,
                fuelType
            );
            vehicle.buy(drivingSchoolId);
            this.repository.save(vehicle);
            this.bus.publish(vehicle.pullDomainEvents());
            return Result.success(vehicle);
        } catch (Exception exception) {
            return Result.failure(exception.getMessage());
        }


    }
}
