package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.mappers;

import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain.*;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.DrivingSchoolModel;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.SectionModel;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.TeacherModel;
import com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.infrastructure.springboot.models.VehicleModel;

import java.util.List;
import java.util.stream.Collectors;

public class DrivingSchoolMapper {

    public static DrivingSchool toDomain(DrivingSchoolModel model) {
        DrivingSchool drivingSchool = new DrivingSchool(
                new CIF(model.getCIF()),
                model.getName()
        );

        List<Section> sections = model.getSections().stream()
                .map(SectionMapper::toDomain)
                .collect(Collectors.toList());
        drivingSchool.setSections(sections);

        List<Teacher> teachers = model.getTeachers().stream()
                .map(TeacherMapper::toDomain)
                .collect(Collectors.toList());
        drivingSchool.setTeachers(teachers);

        List<Vehicle> vehicles = model.getVehicles().stream()
                .map(VehicleMapper::toDomain)
                .collect(Collectors.toList());
        drivingSchool.setVehicles(vehicles);
        drivingSchool.setId(model.getId());

        return drivingSchool;
    }

    public static DrivingSchoolModel toModel(DrivingSchool domain) {
        DrivingSchoolModel model = new DrivingSchoolModel();
        model.setId(domain.getId());
        model.setCIF(domain.getCIF().getCif());
        model.setName(domain.getName());

        List<SectionModel> sectionModels = domain.getSections().stream()
                .map(SectionMapper::toModel)
                .collect(Collectors.toList());
        model.setSections(sectionModels);

        List<TeacherModel> teacherModels = domain.getTeachers().stream()
                .map(TeacherMapper::toModel)
                .collect(Collectors.toList());
        model.setTeachers(teacherModels);

        List<VehicleModel> vehicleModels = domain.getVehicles().stream()
                .map(VehicleMapper::toModel)
                .collect(Collectors.toList());
        model.setVehicles(vehicleModels);

        return model;
    }
}