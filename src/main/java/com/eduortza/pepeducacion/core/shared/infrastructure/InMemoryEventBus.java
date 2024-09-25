package com.eduortza.pepeducacion.core.shared.infrastructure;

import com.eduortza.pepeducacion.core.shared.application.IEventBus;
import com.eduortza.pepeducacion.core.shared.application.IEventHandler;
import com.eduortza.pepeducacion.core.shared.domain.DomainEvent;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEventBus implements IEventBus {
    private final Map<String, List<IEventHandler>> handlers = new HashMap<>();

    @Override
    public void publish(final List<DomainEvent> events) {
        for (DomainEvent event : events) {
            List<IEventHandler> eventHandlers = handlers.get(event.getEventId());
            if (eventHandlers != null) {
                for (IEventHandler handler : eventHandlers) {
                    handler.handle(event);
                }
            }
        }
    }

    @Override
    public void subscribe(IEventHandler handler) {
        this.handlers.putIfAbsent(handler.getEventId(), new ArrayList<>());
        this.handlers.get(handler.getEventId()).add(handler);
    }
}