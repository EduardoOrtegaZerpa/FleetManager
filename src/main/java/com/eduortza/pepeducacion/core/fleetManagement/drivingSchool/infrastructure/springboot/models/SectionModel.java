package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models;

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
@Table(name = "section")
@jakarta.persistence.Entity
public class SectionModel{
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Embedded
    @Column(nullable = false)
    private Location location;
}
