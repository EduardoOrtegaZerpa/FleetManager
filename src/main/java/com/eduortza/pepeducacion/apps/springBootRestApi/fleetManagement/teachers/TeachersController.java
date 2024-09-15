package com.eduortza.pepeducacion.apps.springBootRestApi.fleetManagement.teachers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("teachers")
@RequestMapping("/v1/teachers")
public class TeachersController {
    @GetMapping("/")
    public String index(){
        return "hello from driving teachers";
    }
}
