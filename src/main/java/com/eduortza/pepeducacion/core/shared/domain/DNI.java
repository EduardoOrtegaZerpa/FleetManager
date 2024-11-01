package com.eduortza.pepeducacion.core.shared.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DNI extends ValueObject {
    private final String dni;

    private DNI() {
        this.dni = null;
    }

    public DNI(String dni) {
        if (!isValid(dni)) {
            throw new DomainException("El DNI no es válido");
        }
        this.dni = dni;
    }

    private boolean isValid(String dni) {
        if (dni == null || dni.length() != 9) {
            return false;
        }

        try {
            int number = Integer.parseInt(dni.substring(0, 8));
            char letter = dni.charAt(8);

            return letter == calculateLetter(number);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private char calculateLetter(int number) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(number % 23);
    }
}
