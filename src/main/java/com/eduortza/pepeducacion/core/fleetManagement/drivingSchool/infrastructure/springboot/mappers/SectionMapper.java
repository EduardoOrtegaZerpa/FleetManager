package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.mappers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.Section;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.SectionModel;

public class SectionMapper {

    public static Section toDomain(SectionModel model) {
        Section section = new Section();
        section.setId(model.getId());
        section.setLocation(model.getLocation());
        return section;
    }

    public static SectionModel toModel(Section domain) {
        SectionModel model = new SectionModel();
        model.setId(domain.getId());
        model.setLocation(domain.getLocation());
        return model;
    }
}

