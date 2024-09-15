package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.drivingSchool;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.TeacherHasBeenFiredEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.TeacherHasBeenHiredEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.handlers.VehicleHasBeenBuyedEventHandler;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.DrivingSchool;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.InMemoryDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("driving_schools")
@RequestMapping("/v1/driving_schools")
public class DrivingSchoolsController {
    private final IDrivingSchoolRepository repository = new InMemoryDrivingSchoolRepository();
    private final IEventBus eventBus;

    @Autowired
    public DrivingSchoolsController(IEventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.subscribe(new TeacherHasBeenHiredEventHandler(repository));
        eventBus.subscribe(new TeacherHasBeenFiredEventHandler(repository));
        eventBus.subscribe(new VehicleHasBeenBuyedEventHandler(repository));
    }

    @GetMapping("/")
    public ResponseEntity<List<DrivingSchool>> getDrivingSchoolsQuery() {
        
    }

    @PostMapping("/")
    public String addDrivingSchoolCommand() {
        return "hello from driving schools";
    }

    @PostMapping("/{id}/sections")
    public String openDrivingSchoolSectionCommand(@PathVariable String id) {
        return "hello from driving schools";
    }

}
