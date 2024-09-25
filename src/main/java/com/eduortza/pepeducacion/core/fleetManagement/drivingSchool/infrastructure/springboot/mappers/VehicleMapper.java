package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.mappers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Vehicle;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.VehicleModel;

public class VehicleMapper {

    public static Vehicle toDomain(VehicleModel model) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(model.getId());
        vehicle.setPlate(model.getPlate());
        return vehicle;
    }

    public static VehicleModel toModel(Vehicle domain) {
        VehicleModel model = new VehicleModel();
        model.setId(domain.getId());
        model.setPlate(domain.getPlate());
        return model;
    }
}
