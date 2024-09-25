package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public class TeacherHasBeenFiredEvent extends DomainEvent {
    public TeacherHasBeenFiredEvent(String aggregateId, String dni, String name, String surname, String drivingSchool) {
        super(aggregateId, "teacher-has-been-fired");
        this.getPayload().put("dni", dni);
        this.getPayload().put("name", name);
        this.getPayload().put("surname", surname);
        this.getPayload().put("drivingSchoolId", drivingSchool);
    }

    public static TeacherHasBeenFiredEvent from(Teacher teacher){
        return new TeacherHasBeenFiredEvent(
                teacher.getId().toString(),
                teacher.getDni().getDni(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getDrivingSchool().toString()
        );
    }
}
