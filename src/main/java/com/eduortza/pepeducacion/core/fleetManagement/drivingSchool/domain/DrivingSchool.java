package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class DrivingSchool extends AggregateRoot {
    private CIF CIF;
    private String name;
    private List<Section> sections;
    private List<Teacher> teachers;
    private List<Vehicle> vehicles;


    public void addSection(Section section) {
        this.sections.add(section);
        this.record(new DrivingSchoolSectionHasBeenCreated(
                this.getId().toString(),
                section.getId().toString()));
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
}