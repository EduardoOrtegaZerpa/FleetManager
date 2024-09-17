package com.eduortza.pepeducacion.apps.springBootRestApi;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.application.ports.IDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.models.DrivingSchoolModel;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.repositories.SpringDrivingSchoolRepository;
import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.infrastructure.InMemoryEventBus;
import com.eduortza.pepeducacion.core.shared.infrastructure.JPASpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public IEventBus eventBus() {
        return new InMemoryEventBus();
    }


}
