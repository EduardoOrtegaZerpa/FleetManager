package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.drivingSchool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("driving_schools")
@RequestMapping("/v1/driving_schools")
public class DrivingSchoolsController {
    @GetMapping("/")
    public String index(){
        return "hello from driving schools";
    }
}
