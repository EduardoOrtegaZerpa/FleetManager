package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Entity {
    private UUID id;
    private boolean isActive = true;


    public Entity() {
        this.id = UUID.randomUUID();
    }

    public void makeInactive(){
        this.isActive = false;
    }
}