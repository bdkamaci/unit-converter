package com.bdkamaci.unitconverter.service;

import com.bdkamaci.unitconverter.model.Conversion;

public interface ConverterService {
    Conversion convertLength(Conversion conversion);
    Conversion convertWeight(Conversion conversion);
    Conversion convertTemperature(Conversion conversion);
}
