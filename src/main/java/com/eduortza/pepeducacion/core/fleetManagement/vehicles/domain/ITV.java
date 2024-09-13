package com.eduortza.pepeducacion.core.fleetManagement.vehicles.domain;

import com.eduortza.pepeducacion.core.shared.domain.DomainException;
import com.eduortza.pepeducacion.core.shared.domain.ValueObject;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class ITV extends ValueObject {
    private LocalDate lastInspectionDate;
    private LocalDate nextInspectionDate;

    public ITV(LocalDate lastInspectionDate, LocalDate nextInspectionDate) {
        if (!isValidNextInspectionDate(lastInspectionDate, nextInspectionDate)) {
            throw new DomainException("The next inspection date must be after the last inspection date and in the future.");
        }
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
    }

    private boolean isValidNextInspectionDate(LocalDate lastInspectionDate, LocalDate nextInspectionDate) {
        return nextInspectionDate != null &&
                lastInspectionDate != null &&
                nextInspectionDate.isAfter(lastInspectionDate) &&
                nextInspectionDate.isAfter(LocalDate.now());
    }

    public void updateNextInspectionDate(LocalDate newNextInspectionDate) {
        if (!isValidNextInspectionDate(this.lastInspectionDate, newNextInspectionDate)) {
            throw new DomainException("Invalid next inspection date.");
        }
        this.nextInspectionDate = newNextInspectionDate;
    }

    public boolean isITVExpired() {
        return nextInspectionDate.isBefore(LocalDate.now());
    }
}
