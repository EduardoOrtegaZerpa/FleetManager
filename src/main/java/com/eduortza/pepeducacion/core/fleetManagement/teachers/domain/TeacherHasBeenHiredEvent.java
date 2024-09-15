package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public class TeacherHasBeenHiredEvent extends DomainEvent {
    public TeacherHasBeenHiredEvent(String aggregateId, String dni, String name, String surname, String drivingSchoolId) {
        super(aggregateId, "teacher-has-been-hired");
        this.getPayload().put("dni", dni);
        this.getPayload().put("name", name);
        this.getPayload().put("surname", surname);
        this.getPayload().put("drivingSchoolId", drivingSchoolId);
    }

    public static TeacherHasBeenHiredEvent from(Teacher teacher){
        return new TeacherHasBeenHiredEvent(
                teacher.getId().toString(),
                teacher.getDni().getDni(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getDrivingSchool().toString());
    }
}
