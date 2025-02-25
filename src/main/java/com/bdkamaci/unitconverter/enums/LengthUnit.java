package com.bdkamaci.unitconverter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LengthUnit {
    MILLIMETER("Millimeter", "mm"),
    CENTIMETER("Centimeter", "cm"),
    METER("Meter", "m"),
    KILOMETER("Kilometer", "km"),
    INCH("Inch", "in"),
    FOOT("Foot", "ft"),
    YARD("Yard", "yd"),
    MILE("Mile", "mi");

    private final String displayName;
    private final String symbol;

    // Conversion factor to meters (base unit)
    public double toMeters(double value) {
        return switch (this) {
            case MILLIMETER -> value * 0.001;
            case CENTIMETER -> value * 0.01;
            case METER -> value;
            case KILOMETER -> value * 1000;
            case INCH -> value * 0.0254;
            case FOOT -> value * 0.3048;
            case YARD -> value * 0.9144;
            case MILE -> value * 1609.344;
            default -> throw new IllegalArgumentException("Unknown unit: " + this);
        };
    }

    // Convert from meters to this unit
    public double fromMeters(double meters) {
        return switch (this) {
            case MILLIMETER -> meters / 0.001;
            case CENTIMETER -> meters / 0.01;
            case METER -> meters;
            case KILOMETER -> meters / 1000;
            case INCH -> meters / 0.0254;
            case FOOT -> meters / 0.3048;
            case YARD -> meters / 0.9144;
            case MILE -> meters / 1609.344;
            default -> throw new IllegalArgumentException("Unknown unit: " + this);
        };
    }
}
