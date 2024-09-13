package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.ValueObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Gender extends ValueObject {
    private GenderType gender;

    public enum GenderType {
        MALE,
        FEMALE,
        NON_BINARY,
        UNDISCLOSED,
        HERMAPHRODITE,
        HELICOPTER
    }

    public Gender(GenderType gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        this.gender = gender;
    }

    public void updateGender(GenderType newGender) {
        if (newGender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }
        this.gender = newGender;
    }
}
