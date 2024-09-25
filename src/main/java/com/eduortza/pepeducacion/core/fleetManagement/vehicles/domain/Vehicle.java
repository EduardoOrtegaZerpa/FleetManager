package com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import com.eduortza.pepeducacion.core.shared.domain.Plate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Vehicle extends AggregateRoot {
    public Vehicle(Plate plate, String brand, String model, ITV itv, FuelType fuelType) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.itv = itv;
        this.fuelType = fuelType;
    }

    private UUID drivingSchool;
    private UUID teacher = null;
    private Plate plate;
    private String brand;
    private String model;
    private ITV itv;
    private FuelType fuelType;

    public void buy(UUID drivingSchoolId){
        this.drivingSchool = drivingSchoolId;
        this.recordEvent(new VehicleHasBeenBuyedEvent(this));
    }

    public void associateToTeacher(UUID teacherId){
        this.teacher = teacherId;
        this.recordEvent(new VehicleHasBeenAssociatedToTeacherEvent(this));
    }
}
