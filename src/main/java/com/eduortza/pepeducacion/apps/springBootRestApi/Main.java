package com.eduortza.pepeducacion.apps.springBootRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.repositories")  // Your repository package
@EntityScan(basePackages = "com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models")  // Your repository package
@ComponentScan(basePackages = "com.eduortza.pepeducacion")  // Your base package
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
