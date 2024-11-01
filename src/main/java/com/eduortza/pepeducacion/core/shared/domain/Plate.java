package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Plate extends ValueObject {
    private String plateNumber;

    private Plate() {
        this.plateNumber = null; // Esto solo se usa para cumplir con los requisitos de Hibernate/JPA
    }

    public Plate(String plateNumber) {
        if (!isValidPlate(plateNumber)) {
            throw new DomainException("Invalid plate number format");
        }
        this.plateNumber = plateNumber;
    }

    private boolean isValidPlate(String plateNumber) {
        return plateNumber != null && plateNumber.matches("[A-Z]{3}-\\d{4}");
    }

    public void updatePlateNumber(String newPlateNumber) {
        if (!isValidPlate(newPlateNumber)) {
            throw new DomainException("Invalid plate number format");
        }
        this.plateNumber = newPlateNumber;
    }
}
