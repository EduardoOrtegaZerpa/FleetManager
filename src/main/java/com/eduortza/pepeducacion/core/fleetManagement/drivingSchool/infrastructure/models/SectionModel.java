package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.models;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Location;
import com.eduortza.pepeducacion.core.shared.domain.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@jakarta.persistence.Entity
@Table(name = "section")
public class SectionModel extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Embedded
    @Column(nullable = false)
    private Location location;
}
