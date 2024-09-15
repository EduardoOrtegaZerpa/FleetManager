package com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.ValueObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FuelType extends ValueObject {
    private Fuel fuel;

    public enum Fuel {
        GASOLINE,
        DIESEL,
        ELECTRIC,
        HYBRID,
        LPG,
        CNG;

        public static Fuel fromString(String fuel) {
            if (fuel == null || fuel.isBlank()) {
                throw new DomainException("Fuel string cannot be null or empty.");
            }

            try {
                return Fuel.valueOf(fuel.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new DomainException("Invalid fuel value: " + fuel);
            }
        }
    }

    public FuelType(String fuel) {
        if (fuel == null || fuel.isBlank()) {
            throw new DomainException("Fuel string cannot be null or empty.");
        }
        this.fuel = Fuel.fromString(fuel);
    }

    public void updateFuelType(String newFuel) {
        if (newFuel == null || newFuel.isBlank()) {
            throw new DomainException("Fuel string cannot be null or empty.");
        }
        this.fuel = Fuel.fromString(newFuel);
    }
}
