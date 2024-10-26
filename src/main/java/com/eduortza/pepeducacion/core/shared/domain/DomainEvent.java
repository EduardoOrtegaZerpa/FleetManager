package com.eduortza.pepeducacion.core.shared.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static DomainEvent fromJson(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(body, DomainEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
