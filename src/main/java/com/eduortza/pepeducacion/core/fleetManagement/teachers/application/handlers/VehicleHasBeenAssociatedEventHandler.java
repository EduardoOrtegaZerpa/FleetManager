package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.handlers;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

import java.beans.EventHandler;

public class VehicleHasBeenAssociatedEventHandler implements IEventHandler {

    private final ITeachersRepository repository;

    public VehicleHasBeenAssociatedEventHandler(ITeachersRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(DomainEvent event) {

    }

    @Override
    public String getEventId() {
        return "vehicle-has-been-associated-to-teacher";
    }
}
