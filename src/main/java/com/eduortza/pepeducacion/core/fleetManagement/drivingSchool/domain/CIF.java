package com.eduortza.pepeducacion.core.fleetManagement.drivingSchool.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.ValueObject;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CIF extends ValueObject {
    private final String cif;

    public CIF(String cif) {
        if (!isValid(cif)) {
            throw new DomainException("El CIF no es válido");
        }
        this.cif = cif;
    }

    private boolean isValid(String cif) {
        if (cif == null || cif.length() != 9) {
            return false;
        }

        char firstChar = cif.charAt(0);
        if (!isValidFirstChar(firstChar)) {
            return false;
        }

        try {
            int numberPart = Integer.parseInt(cif.substring(1, 8));
            char controlChar = cif.charAt(8);

            return controlChar == calculateControlChar(numberPart, firstChar);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidFirstChar(char c) {
        return "ABCDEFGHJNPQRSUVW".indexOf(c) != -1;
    }

    private char calculateControlChar(int numberPart, char firstChar) {
        int sumEven = 0, sumOdd = 0;
        String numberStr = String.valueOf(numberPart);

        // Sumar pares e impares
        for (int i = 0; i < numberStr.length(); i++) {
            int digit = Character.getNumericValue(numberStr.charAt(i));
            if (i % 2 == 0) { // Posiciones impares (pares en la cadena por índice 0)
                int doubled = digit * 2;
                sumOdd += (doubled > 9) ? doubled - 9 : doubled;
            } else {
                sumEven += digit;
            }
        }

        int totalSum = sumEven + sumOdd;
        int controlNumber = (10 - (totalSum % 10)) % 10;

        // Tipos de control: numérico o letra
        if ("ABEH".indexOf(firstChar) != -1) {
            return (char) ('0' + controlNumber);  // Control numérico
        } else {
            String controlLetters = "JABCDEFGHI";
            return controlLetters.charAt(controlNumber); // Control por letra
        }
    }
}