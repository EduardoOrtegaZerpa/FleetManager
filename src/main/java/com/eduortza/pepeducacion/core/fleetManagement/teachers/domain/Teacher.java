package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.AggregateRoot;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends AggregateRoot {
    private UUID drivingSchool;
    private DNI dni;
    private List<UUID> vehicles;
    private String name;
    private String surname;
    private Number age;
    private Gender gender;


}
