package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.drivingSchool;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands.AddDrivingSchoolCommand;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands.AddDrivingSchoolDTO;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands.OpenSectionCommand;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.commands.OpenSectionDTO;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.TeacherHasBeenFiredEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.TeacherHasBeenHiredEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.VehicleHasBeenBuyedEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.queries.GetDrivingSchoolsQuery;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.repositories.SpringDrivingSchoolJpaRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.repositories.SpringDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("driving_schools")
@RequestMapping("/v1/driving_schools")
public class DrivingSchoolsController {
    private final IDrivingSchoolRepository repository;
    private final IEventBus eventBus;

    @Autowired
    public DrivingSchoolsController(IEventBus eventBus, SpringDrivingSchoolJpaRepository repository) {
        this.repository = new SpringDrivingSchoolRepository(repository);
        this.eventBus = eventBus;
        eventBus.subscribe(new TeacherHasBeenHiredEventHandler(this.repository));
        eventBus.subscribe(new TeacherHasBeenFiredEventHandler(this.repository));
        eventBus.subscribe(new VehicleHasBeenBuyedEventHandler(this.repository));
    }

    @GetMapping("/")
    public Result<List<DrivingSchool>> getDrivingSchoolsQuery() {
        var query = new GetDrivingSchoolsQuery(this.repository);
        return query.query(null);
    }

    @PostMapping("/")
    public Result<DrivingSchool> addDrivingSchoolCommand(@RequestBody AddDrivingSchoolDTO dto) {
        var command = new AddDrivingSchoolCommand(this.repository, this.eventBus);
        return command.run(dto);
    }

    @PostMapping("/{id}/sections")
    public Result<Section> openDrivingSchoolSectionCommand(
            @PathVariable String id,
            @RequestBody OpenSectionDTO dto
            ) {
        var command = new OpenSectionCommand(this.repository, this.eventBus);
        return command.run(dto);
    }

}
