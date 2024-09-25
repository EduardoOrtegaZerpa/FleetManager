package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Vehicle;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;
import com.eduortza.pepeducacion.core.shared.domain.Plate;

import java.util.UUID;

public class VehicleHasBeenBuyedEventHandler implements IEventHandler {
    private final IDrivingSchoolRepository repository;

    public VehicleHasBeenBuyedEventHandler(IDrivingSchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(DomainEvent event) {
        var vehicle = new Vehicle(new Plate(event.getPayload().get("plate")));
        var drivingSchoolId = UUID.fromString(event.getPayload().get("drivingSchool"));
        var optionalDrivingSchool = repository.findById(drivingSchoolId);
        if(optionalDrivingSchool.isEmpty()) return;
        var drivingSchool = optionalDrivingSchool.get();
        drivingSchool.addVehicle(vehicle);
        this.repository.save(drivingSchool);
    }

    @Override
    public String getEventId() {
        return "vehicle-has-been-buyed";
    }
}
