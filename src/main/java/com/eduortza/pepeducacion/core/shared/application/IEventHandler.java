package com.eduortza.pepeducacion.core.shared.application;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public interface IEventHandler {
    void handle(DomainEvent event);
    String getEventId();
}
