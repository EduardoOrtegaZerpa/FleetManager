package com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.shared.application.ICommand;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.Result;

import java.util.UUID;

public class FireTeacherCommand implements ICommand<FireTeacherDTO, Void> {
    private final ITeachersRepository repository;
    private final IEventBus bus;

    public FireTeacherCommand(ITeachersRepository repository, IEventBus eventBus) {
        this.repository = repository;
        this.bus = eventBus;
    }

    @Override
    public Result<Void> run(FireTeacherDTO request) {
        try{
            UUID teacherId = UUID.fromString(request.id());
            var optionalTeacher = repository.findById(teacherId);
            if(optionalTeacher.isEmpty()) return Result.failure("Teacher not found.");
            Teacher teacher = optionalTeacher.get();
            teacher.fire();
            this.repository.save(teacher);
            this.bus.publish(teacher.pullDomainEvents());
            return Result.success(null);
        } catch (Exception exception){
            return Result.failure(exception.getMessage());
        }
    }

}
