package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.teachers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.InMemoryDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.handlers.VehicleHasBeenAssociatedEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.infrastructure.InMemoryTeachersRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String getAllTeachersQuery(){
        return "hello from driving teachers";
    }

    @PostMapping("/")
    public String hireTeacherCommand(){
        return "hello from driving teachers";
    }

    @PostMapping("/{id}")
    public String fireTeacherCommand(@PathVariable String id){
        return "hello from driving teachers";
    }
}
