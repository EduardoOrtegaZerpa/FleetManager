package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Entity {
    private UUID id;


    public Entity() {
        this.id = UUID.randomUUID();
    }
}