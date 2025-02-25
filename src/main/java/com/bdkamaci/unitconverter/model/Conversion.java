package com.bdkamaci.unitconverter.model;

import lombok.Data;

@Data
public class Conversion {
    private Double inputValue;
    private String fromUnit;
    private String toUnit;
    private Double result;
    private String conversionType; // length, weight, temperature
}
