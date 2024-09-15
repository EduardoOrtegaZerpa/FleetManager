package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Gender;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.DNI;
import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.UUID;

public class HireTeacherCommand implements ICommand<HireTeacherDTO, Teacher> {
    private final ITeachersRepository repository;
    private final IEventBus bus;

    public HireTeacherCommand(ITeachersRepository repository, IEventBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    @Override
    public Result<Teacher> run(HireTeacherDTO request) {
        try {
            UUID drivingSchoolId = UUID.fromString(request.drivingSchoolId());
            //FIXME: Check if UUID is valid or not
            DNI dni = new DNI(request.dni());
            Gender gender = new Gender(request.gender());
            Teacher teacher = new Teacher(
                    dni,
                    request.name(),
                    request.surname(),
                    request.age(),
                    gender
            );
            teacher.hire(drivingSchoolId);
            this.repository.save(teacher);
            this.bus.publish(teacher.pullDomainEvents());
            return Result.success(teacher);
        } catch (Exception exception){
            return Result.failure(exception.getMessage());
        }
    }
}
