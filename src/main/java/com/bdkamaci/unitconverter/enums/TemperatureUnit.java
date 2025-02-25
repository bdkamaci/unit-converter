package com.bdkamaci.unitconverter.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemperatureUnit {
    CELSIUS("Celsius", "°C"),
    FAHRENHEIT("Fahrenheit", "°F"),
    KELVIN("Kelvin", "K");

    private final String displayName;
    private final String symbol;

    // Temperature conversions are different from linear conversions
    public double convert(double value, TemperatureUnit toUnit) {
        // First convert to Celsius
        double celsius = switch (this) {
            case CELSIUS -> value;
            case FAHRENHEIT -> (value - 32) * 5 / 9;
            case KELVIN -> value - 273.15;
            default -> throw new IllegalArgumentException("Unknown unit: " + this);
        };

        // Then convert from Celsius to target unit
        return switch (toUnit) {
            case CELSIUS -> celsius;
            case FAHRENHEIT -> celsius * 9 / 5 + 32;
            case KELVIN -> celsius + 273.15;
            default -> throw new IllegalArgumentException("Unknown unit: " + toUnit);
        };
    }
}
