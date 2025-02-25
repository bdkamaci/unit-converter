package com.bdkamaci.unitconverter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeightUnit {
    MILLIGRAM("Milligram", "mg"),
    GRAM("Gram", "g"),
    KILOGRAM("Kilogram", "kg"),
    OUNCE("Ounce", "oz"),
    POUND("Pound", "lb");

    private final String displayName;
    private final String symbol;

    // Conversion factor to kilograms (base unit)
    public double toKilograms(double value) {
        return switch (this) {
            case MILLIGRAM -> value * 0.000001;
            case GRAM -> value * 0.001;
            case KILOGRAM -> value;
            case OUNCE -> value * 0.0283495;
            case POUND -> value * 0.453592;
            default -> throw new IllegalArgumentException("Unknown unit: " + this);
        };
    }

    // Convert from kilograms to this unit
    public double fromKilograms(double kilograms) {
        return switch (this) {
            case MILLIGRAM -> kilograms / 0.000001;
            case GRAM -> kilograms / 0.001;
            case KILOGRAM -> kilograms;
            case OUNCE -> kilograms / 0.0283495;
            case POUND -> kilograms / 0.453592;
            default -> throw new IllegalArgumentException("Unknown unit: " + this);
        };
    }
}
