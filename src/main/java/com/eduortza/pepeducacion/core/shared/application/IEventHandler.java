package com.eduortza.pepeducacion.core.shared.application;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

public interface IEventHandler<G extends DomainEvent> {
    void handle(G event);
}
