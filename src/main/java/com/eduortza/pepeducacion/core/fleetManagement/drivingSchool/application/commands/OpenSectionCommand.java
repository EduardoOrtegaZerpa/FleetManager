package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Location;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.UUID;

public class OpenSectionCommand implements ICommand<OpenSectionDTO, Section> {
    private final IDrivingSchoolRepository repository;
    private final IEventBus bus;

    public OpenSectionCommand(IDrivingSchoolRepository repository, IEventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Result<Section> run(OpenSectionDTO request) {
        try {
            if(request.drivingSchoolId() == null) return Result.failure("Driving school id is missing");
            var uuid = UUID.fromString(request.drivingSchoolId());
            var section = createSectionFromRequest(request);
            var optionalDrivingSchool = this.repository.findById(uuid);

            if (optionalDrivingSchool.isEmpty()) return Result.failure("Driving school not found");
            var drivingSchool = optionalDrivingSchool.get();
            drivingSchool.addSection(section);

            this.repository.save(drivingSchool);
            this.bus.publish(drivingSchool.pullDomainEvents());
            return Result.success(section);
        } catch (Exception exception){
           return Result.failure(exception.getMessage());
        }
    }

    private static Section createSectionFromRequest(OpenSectionDTO request) {
        return new Section(new Location(request.latitude(), request.longitude()));
    }
}