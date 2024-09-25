package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands;

public record HireTeacherDTO (
    String dni,
    String name,
    String surname,
    Number age,
    String gender,
    String drivingSchoolId
) {}

