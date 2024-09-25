package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models;

import com.eduortza.pepeducacion.core.shared.domain.Plate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@jakarta.persistence.Entity
@Table(name = "vehicle")
public class VehicleModel{

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Embedded
    @Column(nullable = false)
    private Plate plate;
}
