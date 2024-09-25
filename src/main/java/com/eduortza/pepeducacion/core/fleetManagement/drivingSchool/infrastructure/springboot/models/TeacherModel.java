package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models;

import com.eduortza.pepeducacion.core.shared.domain.DNI;
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
@Table(name = "teacher")
public class TeacherModel{
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Embedded
    @Column(nullable = false)
    private DNI DNI;
}
