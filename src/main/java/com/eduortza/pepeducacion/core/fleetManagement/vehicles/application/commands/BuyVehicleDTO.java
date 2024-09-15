package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands;

import java.time.LocalDate;

public record BuyVehicleDTO (
    String plate,
    String brand,
    String model,
    LocalDate lastInspectionDate,
    LocalDate nextInspectionDate,
    String fuelType,
    String drivingSchoolId
) {}
