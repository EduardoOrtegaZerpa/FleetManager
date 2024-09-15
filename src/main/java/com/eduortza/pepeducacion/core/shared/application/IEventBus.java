package com.eduortza.pepeducacion.core.shared.application;

import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

import java.beans.EventHandler;
import java.util.List;

public interface IEventBus {
    void publish(final List<DomainEvent> events);
    void subscribe(IEventHandler handler);
}