package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends AggregateRoot {
    private UUID drivingSchool;  // Optional, can be assigned later
    private DNI dni;
    private List<String> vehicles;
    private String name;
    private String surname;
    private Number age;
    private Gender gender;

    // Constructor without drivingSchool
    public Teacher(DNI dni, String name, String surname, Number age, Gender gender) {
        this.dni = dni;
        this.vehicles = new ArrayList<>();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
     }

    public void fire() {
        this.makeInactive();
        this.recordEvent(TeacherHasBeenFiredEvent.from(this));
    }

    public void hire(UUID drivingSchool) {
        this.drivingSchool = drivingSchool;
        this.recordEvent(TeacherHasBeenHiredEvent.from(this));
    }
}
