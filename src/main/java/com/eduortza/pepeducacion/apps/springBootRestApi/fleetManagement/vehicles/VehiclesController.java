package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.vehicles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("vehicles")
@RequestMapping("/v1/vehicles")
public class VehiclesController {
    @GetMapping("/")
    public String index(){
        return "hello from vehicles";
    }
}
