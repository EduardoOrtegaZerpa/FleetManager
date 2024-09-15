package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

public record OpenSectionDTO(
        String drivingSchoolId,
        double latitude,
        double longitude
) {
}
