package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.vehicles;

import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands.AssociateVehicleCommand;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands.AssociateVehicleDTO;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands.BuyVehicleCommand;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.commands.BuyVehicleDTO;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.ports.IVehiclesRepository;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.application.queries.FindAllVehiclesQuery;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain.Vehicle;
import com.eduortza.pepeducacion.core.fleetManagement.vehicles.infrastructure.InMemoryVehicleRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("vehicles")
@RequestMapping("/v1/vehicles")
public class VehiclesController {
    private final IVehiclesRepository repository = new InMemoryVehicleRepository();
    private final IEventBus eventBus;

    @Autowired
    public VehiclesController(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @GetMapping("/")
    public Result<List<Vehicle>> findAllVehiclesQuery(){
        var query = new FindAllVehiclesQuery(repository);
        return query.query(null);
    }

    @PostMapping("/associate/")
    public Result<Void> associateVehicleCommand(@RequestBody AssociateVehicleDTO dto){
        var command = new AssociateVehicleCommand(repository, eventBus);
        return command.run(dto);
    }

    @PostMapping("/")
    public Result<Vehicle> buyVehicleCommand(
            @RequestBody BuyVehicleDTO dto
            ){
        var command = new BuyVehicleCommand(repository, eventBus);
        return command.run(dto);
    }
}
