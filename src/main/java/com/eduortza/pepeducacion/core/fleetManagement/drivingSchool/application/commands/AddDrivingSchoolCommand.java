package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.Result;

public class AddDrivingSchoolCommand implements ICommand<DrivingSchool, DrivingSchool> {
    private final IDrivingSchoolRepository repository;
    private final IEventBus eventBus;

    public AddDrivingSchoolCommand(IDrivingSchoolRepository repository, IEventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Override
    public Result<DrivingSchool> run(DrivingSchool request) {
        repository.save(request);
        eventBus.publish(request.pullDomainEvents());
        return Result.success(request);
    }
}