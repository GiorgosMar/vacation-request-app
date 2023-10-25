package com.vacationRequest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BonusRate {
    AUTUMN(0.4),
    WINTER(1.3),
    SPRING(0.6),
    SUMMER(0.7);

   private final double value;
   public static BonusRate resolve(String season) {
       for (BonusRate bonusRate : BonusRate.values()) {
            if (bonusRate.name().equalsIgnoreCase(season)) {
                return bonusRate;
            }
        }
       return null;
   }
}
