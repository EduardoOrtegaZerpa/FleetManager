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
        CNG
    }

    public FuelType(Fuel fuel) {
        if (fuel == null) {
            throw new DomainException("Fuel type cannot be null.");
        }
        this.fuel = fuel;
    }

    public void updateFuelType(Fuel newFuel) {
        if (newFuel == null) {
            throw new DomainException("Fuel type cannot be null.");
        }
        this.fuel = newFuel;
    }
}
