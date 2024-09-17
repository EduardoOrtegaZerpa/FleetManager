package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "driving_school")
public class DrivingSchoolModel{
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String CIF;
    @Column(nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SectionModel> sections;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeacherModel> teachers;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleModel> vehicles;
}
