package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Location extends ValueObject {
    private double latitude;
    private double longitude;

    public Location(){}
}
