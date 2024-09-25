package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.teachers;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands.FireTeacherCommand;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands.FireTeacherDTO;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands.HireTeacherCommand;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.commands.HireTeacherDTO;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.handlers.VehicleHasBeenAssociatedEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.queries.GetAllTeachersQuery;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.domain.Teacher;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.infrastructure.InMemoryTeachersRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("teachers")
@RequestMapping("/v1/teachers")
public class TeachersController {
    private final ITeachersRepository repository = new InMemoryTeachersRepository();
    private final IEventBus eventBus;

    @Autowired
    public TeachersController(IEventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.subscribe(new VehicleHasBeenAssociatedEventHandler(repository));
    }

    @GetMapping("/")
    public Result<List<Teacher>> getAllTeachersQuery(){
        var query = new GetAllTeachersQuery(repository);
        return query.query(null);
    }

    @PostMapping("/")
    public Result<Teacher> hireTeacherCommand(
            @RequestBody HireTeacherDTO dto
            ){
        var command = new HireTeacherCommand(repository, eventBus);
        return command.run(dto);
    }

    @PostMapping("/fire")
    public Result<Void> fireTeacherCommand(
            @RequestBody FireTeacherDTO dto
            ){
        var command = new FireTeacherCommand(repository, eventBus);
        return command.run(dto);
    }
}
