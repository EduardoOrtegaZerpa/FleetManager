package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
public class DomainEvent {
    private final String eventId;
    private final String aggregateId;
    private final String occurredOn;

    public DomainEvent(String aggregateId, String eventId) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = LocalDate.now().toString();
    }

}
