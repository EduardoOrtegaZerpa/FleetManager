package com.eduortza.pepeducacion.core.shared.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AggregateRoot extends Entity{

    private List<DomainEvent> events = new ArrayList<>();

    public List<DomainEvent> pullDomainEvents(){
        List<DomainEvent> events = this.events;
        this.events = new ArrayList<>();
        return events;
    }

    public void record(DomainEvent event){
        this.events.add(event);
    }

    public  void  clearEvents(){
        this.events.clear();
    }
}
