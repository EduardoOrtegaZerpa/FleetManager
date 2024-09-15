package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

import java.util.UUID;

public class TeacherHasBeenHiredEventHandler implements IEventHandler {
    private final IDrivingSchoolRepository repository;

    public TeacherHasBeenHiredEventHandler(IDrivingSchoolRepository repository) {
        this.repository = repository;
    }


    @Override
    public void handle(DomainEvent event) {
        var drivingSchoolId = event.getPayload().get("drivingSchoolId");
        var uuid = UUID.fromString(drivingSchoolId);
        var teacherDni = event.getPayload().get("dni");
        var optionalDrivingSchool = this.repository.findById(uuid);
        var teacherId = event.getAggregateId();
        if(optionalDrivingSchool.isEmpty()) return;
        var drivingSchool = optionalDrivingSchool.get();
        drivingSchool.removeTeacher(new DNI(teacherDni));
        repository.save(drivingSchool);
    }

    @Override
    public String getEventId() {
        return "teacher-has-been-hired";
    }
}
