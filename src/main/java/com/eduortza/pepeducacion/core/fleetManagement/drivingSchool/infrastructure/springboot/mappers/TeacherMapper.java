package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.mappers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Teacher;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.TeacherModel;

public class TeacherMapper {

    public static Teacher toDomain(TeacherModel model) {
        Teacher teacher = new Teacher();
        teacher.setId(model.getId());
        teacher.setDNI(model.getDNI());
        return teacher;
    }

    public static TeacherModel toModel(Teacher domain) {
        TeacherModel model = new TeacherModel();
        model.setId(domain.getId());
        model.setDNI(domain.getDNI());
        return model;
    }
}
