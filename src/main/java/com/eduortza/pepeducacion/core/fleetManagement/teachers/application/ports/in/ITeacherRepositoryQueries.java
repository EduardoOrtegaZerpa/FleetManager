package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.in;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;

import java.util.List;

public interface ITeacherRepositoryQueries {
    List<Teacher> getTeachers();
}
