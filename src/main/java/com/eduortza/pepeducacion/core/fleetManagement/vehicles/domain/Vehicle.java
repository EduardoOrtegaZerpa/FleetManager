package com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import com.eduortza.pepeducacion.core.shared.domain.Plate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Vehicle extends AggregateRoot {
    private UUID drivingSchool;
    private UUID teacher;
    private Plate plate;
    private String brand;
    private String model;
    private ITV ITV;
    private FuelType fuelType;
}
