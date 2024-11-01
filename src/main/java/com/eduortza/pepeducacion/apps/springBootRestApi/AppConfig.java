package com.eduortza.pepeducacion.apps.springBootRestApi;

import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.infrastructure.InMemoryEventBus;
import com.eduortza.pepeducacion.core.shared.infrastructure.SqsEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IEventBus eventBus() {
        return new SqsEventBus("https://sqs.us-east-1.amazonaws.com/701368024543/queue");
    }
}
