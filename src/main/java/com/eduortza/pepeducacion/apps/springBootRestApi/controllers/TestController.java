package com.eduortza.pepeducacion.apps.springBootRestApi.controllers;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/index")
    public String index(){
        return "Hello world";
    }
}
