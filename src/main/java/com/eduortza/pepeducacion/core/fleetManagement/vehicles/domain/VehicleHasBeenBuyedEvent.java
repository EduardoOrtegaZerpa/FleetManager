package com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public class VehicleHasBeenBuyedEvent extends DomainEvent {
    public VehicleHasBeenBuyedEvent(Vehicle vehicle) {
        super(vehicle.getId().toString(), "vehicle-has-been-buyed");
        this.getPayload().put("brand", vehicle.getBrand());
        this.getPayload().put("model", vehicle.getModel());
        this.getPayload().put("plate", vehicle.getPlate().getPlateNumber());
        this.getPayload().put("drivingSchool", vehicle.getDrivingSchool().toString());
    }
}
