package com.bdkamaci.unitconverter.service.impl;

import com.bdkamaci.unitconverter.enums.LengthUnit;
import com.bdkamaci.unitconverter.enums.TemperatureUnit;
import com.bdkamaci.unitconverter.enums.WeightUnit;
import com.bdkamaci.unitconverter.model.Conversion;
import com.bdkamaci.unitconverter.service.ConverterService;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

    @Override
    public Conversion convertLength(Conversion conversion) {
        if (conversion.getInputValue() == null || conversion.getFromUnit() == null || conversion.getToUnit() == null) {
            return conversion;
        }

        LengthUnit fromUnit = LengthUnit.valueOf(conversion.getFromUnit());
        LengthUnit toUnit = LengthUnit.valueOf(conversion.getToUnit());
        double meters = fromUnit.toMeters(conversion.getInputValue());
        double result = toUnit.fromMeters(meters);

        // Round to 4 decimal places
        result = Math.round(result * 10000.0) / 10000.0;

        conversion.setResult(result);
        return conversion;
    }

    @Override
    public Conversion convertWeight(Conversion conversion) {
        if (conversion.getInputValue() == null || conversion.getFromUnit() == null || conversion.getToUnit() == null) {
            return conversion;
        }

        WeightUnit fromUnit = WeightUnit.valueOf(conversion.getFromUnit());
        WeightUnit toUnit = WeightUnit.valueOf(conversion.getToUnit());
        double kilograms = fromUnit.toKilograms(conversion.getInputValue());
        double result = toUnit.fromKilograms(kilograms);

        // Round to 4 decimal places
        result = Math.round(result * 10000.0) / 10000.0;

        conversion.setResult(result);
        return conversion;
    }

    @Override
    public Conversion convertTemperature(Conversion conversion) {
        if (conversion.getInputValue() == null || conversion.getFromUnit() == null || conversion.getToUnit() == null) {
            return conversion;
        }

        TemperatureUnit fromUnit = TemperatureUnit.valueOf(conversion.getFromUnit());
        TemperatureUnit toUnit = TemperatureUnit.valueOf(conversion.getToUnit());
        double result = fromUnit.convert(conversion.getInputValue(), toUnit);

        // Round to 2 decimal places
        result = Math.round(result * 100.0) / 100.0;

        conversion.setResult(result);
        return conversion;
    }
}
