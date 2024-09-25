package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
public class DomainEvent {
    private final String eventId;
    private final String aggregateId;
    private final String occurredOn;
    private final Map<String, String> payload;

    public DomainEvent(String aggregateId, String eventId) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.payload = new HashMap<>();
        this.occurredOn = LocalDate.now().toString();
    }

}
