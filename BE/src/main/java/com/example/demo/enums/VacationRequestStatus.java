package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VacationRequestStatus {
    ACCEPTED("accepted"),
    REJECTED("rejected"),
    PENDING("pending"),
    APPROVED("approved");

    private final String value;
    public static VacationRequestStatus resolve(String status) {
        for (VacationRequestStatus vacationRequestStatus : VacationRequestStatus.values()) {
            if (vacationRequestStatus.name().equalsIgnoreCase(status)) {
                return vacationRequestStatus;
            }
        }
        return null;
    }
}
