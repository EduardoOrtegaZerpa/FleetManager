package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public class DrivingSchoolSectionHasBeenCreated extends DomainEvent {
    private final String sectionId;

    public DrivingSchoolSectionHasBeenCreated(String aggregateId, String sectionId) {
        super(aggregateId, "driving-school-has-been-created");
        this.sectionId = sectionId;
    }
}
