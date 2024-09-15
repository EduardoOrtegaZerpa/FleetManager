package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.vehicles;

import com.eduortza.pepeducacion.core.fleetManagement.teachers.application.ports.ITeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.teachers.infrastructure.InMemoryTeachersRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.infrastructure.InMemoryVehicleRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("vehicles")
@RequestMapping("/v1/vehicles")
public class VehiclesController {
    private final IVehiclesRepository repository = new InMemoryVehicleRepository();

    @Autowired
    public VehiclesController(IEventBus eventBus) {
    }

    @GetMapping("/")
    public String findAllVehiclesQuery(){
        return "hello from vehicles";
    }

    @PostMapping("/{id}/associate/")
    public String associateVehicleCommand(@PathVariable String id){
        return "hello from vehicles";
    }

    @PostMapping("/")
    public String buyVehicleCommand(){
        return "";
    }
}
