package com.eduortza.pepeducacion.core.fleetManagement.teachers.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.domain.DNI;

public interface ITeacherRepositoryCommands {
    void contractTeacher(CIF drivingSchoolId, Teacher teacher);
    void fireTeacher(CIF drivingSchoolId, DNI teacherId);
}
