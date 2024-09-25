package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Section extends Entity {
    private Location location;
}
