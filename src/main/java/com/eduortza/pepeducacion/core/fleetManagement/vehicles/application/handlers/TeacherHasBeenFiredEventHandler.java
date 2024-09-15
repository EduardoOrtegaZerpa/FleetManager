package com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.handlers;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public class TeacherHasBeenFiredEventHandler implements IEventHandler {

    private final IVehiclesRepository repository;

    public TeacherHasBeenFiredEventHandler(IVehiclesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(DomainEvent event) {
    }

    @Override
    public String getEventId() {
        return "teacher-has-been-hired";
    }
}
