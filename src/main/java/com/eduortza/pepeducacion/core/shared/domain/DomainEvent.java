package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;

@Getter
public class DomainEvent {
    private final String eventId;
    private final String aggregateId;
    private final String occurredOn;

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

}
