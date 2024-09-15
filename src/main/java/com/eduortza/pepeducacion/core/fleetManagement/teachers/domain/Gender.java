package com.eduortza.pepeducacion.core.fleetManagement.teachers.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainException;
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
        HELICOPTER;

        public static GenderType fromString(String gender) {
            if (gender == null || gender.isBlank()) {
                throw new IllegalArgumentException("Gender string cannot be null or empty.");
            }

            try {
                return GenderType.valueOf(gender.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid gender value: " + gender);
            }
        }
    }

    public Gender(String gender) {
        if (gender == null || gender.isBlank()) {
            throw new IllegalArgumentException("Gender string cannot be null or empty.");
        }
        this.gender = GenderType.fromString(gender);
    }

    public void updateGender(String newGender) {
        if (newGender == null || newGender.isBlank()) {
            throw new IllegalArgumentException("Gender string cannot be null or empty.");
        }
        this.gender = GenderType.fromString(newGender);
    }
}
