package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.CIF;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.Result;

public class AddDrivingSchoolCommand implements ICommand<AddDrivingSchoolDTO, DrivingSchool> {
    private final IDrivingSchoolRepository repository;
    private final IEventBus eventBus;

    public AddDrivingSchoolCommand(IDrivingSchoolRepository repository, IEventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Override
    public Result<DrivingSchool> run(AddDrivingSchoolDTO request) {
        try {
            CIF cif = new CIF(request.cif());
            String name = request.name();
            DrivingSchool drivingSchool = new DrivingSchool(cif, name);
            repository.save(drivingSchool);
            eventBus.publish(drivingSchool.pullDomainEvents());
            return Result.success(drivingSchool);
        }catch (Exception exception){
            return Result.failure(exception.getMessage());
        }
    }
}