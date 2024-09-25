package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DrivingSchool extends AggregateRoot {
    private CIF CIF;
    private String name;
    private List<Section> sections = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    public DrivingSchool(CIF cif, String name) {
        this.CIF = cif;
        this.name = name;
    }

    public void addSection(Section section) {
        this.sections.add(section);
        this.recordEvent(new DrivingSchoolSectionHasBeenCreated(
                this.getId().toString(),
                section.getId().toString()));
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeTeacher(DNI dni) {
        this.teachers.removeIf(teacher -> teacher.getDNI().getDni().equals(dni.getDni()));
    }
}