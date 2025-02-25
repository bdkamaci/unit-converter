package com.bdkamaci.unitconverter.controller;

import com.bdkamaci.unitconverter.enums.TemperatureUnit;
import com.bdkamaci.unitconverter.enums.WeightUnit;
import com.bdkamaci.unitconverter.model.Conversion;
import com.bdkamaci.unitconverter.enums.LengthUnit;
import com.bdkamaci.unitconverter.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterControllerTest {

    @InjectMocks
    private ConverterServiceImpl converterService;

    @Mock
    private LengthUnit lengthUnitMock;

    @Mock
    private WeightUnit weightUnitMock;

    @Mock
    private TemperatureUnit temperatureUnitMock;

    @BeforeEach
    void setUp() {
        // Initialize mocks before each test
        MockitoAnnotations.openMocks(this);
    }

    // Test for Length Conversion
    @Test
    void testConvertLength() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(1000.0);
        conversion.setFromUnit("METER");
        conversion.setToUnit("KILOMETER");

        LengthUnit fromUnit = LengthUnit.METER;
        LengthUnit toUnit = LengthUnit.KILOMETER;

        double meters = fromUnit.toMeters(conversion.getInputValue());
        double result = toUnit.fromMeters(meters);

        when(lengthUnitMock.toMeters(1000.0)).thenReturn(1000.0);
        when(lengthUnitMock.fromMeters(1000.0)).thenReturn(1.0);

        Conversion resultConversion = converterService.convertLength(conversion);

        assertEquals(1.0, resultConversion.getResult());
    }

    // Test for Weight Conversion
    @Test
    void testConvertWeight() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(1000.0);
        conversion.setFromUnit("GRAM");
        conversion.setToUnit("KILOGRAM");

        WeightUnit fromUnit = WeightUnit.GRAM;
        WeightUnit toUnit = WeightUnit.KILOGRAM;

        double kilograms = fromUnit.toKilograms(conversion.getInputValue());
        double result = toUnit.fromKilograms(kilograms);

        when(weightUnitMock.toKilograms(1000.0)).thenReturn(1.0);
        when(weightUnitMock.fromKilograms(1.0)).thenReturn(1.0);

        Conversion resultConversion = converterService.convertWeight(conversion);

        assertEquals(1.0, resultConversion.getResult());
    }

    // Test for Temperature Conversion
    @Test
    void testConvertTemperature() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(100.0);
        conversion.setFromUnit("CELSIUS");
        conversion.setToUnit("FAHRENHEIT");

        TemperatureUnit fromUnit = TemperatureUnit.CELSIUS;
        TemperatureUnit toUnit = TemperatureUnit.FAHRENHEIT;

        double result = fromUnit.convert(conversion.getInputValue(), toUnit);

        when(temperatureUnitMock.convert(100.0, toUnit)).thenReturn(212.0);

        Conversion resultConversion = converterService.convertTemperature(conversion);

        assertEquals(212.0, resultConversion.getResult());
    }

    // Test for Null Input Handling in Length Conversion
    @Test
    void testConvertLength_NullInput() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(null);
        conversion.setFromUnit("METER");
        conversion.setToUnit("KILOMETER");

        Conversion result = converterService.convertLength(conversion);

        assertNull(result.getResult());
    }

    // Test for Null Input Handling in Weight Conversion
    @Test
    void testConvertWeight_NullInput() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(null);
        conversion.setFromUnit("GRAM");
        conversion.setToUnit("KILOGRAM");

        Conversion result = converterService.convertWeight(conversion);

        assertNull(result.getResult());
    }

    // Test for Null Input Handling in Temperature Conversion
    @Test
    void testConvertTemperature_NullInput() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(null);
        conversion.setFromUnit("CELSIUS");
        conversion.setToUnit("FAHRENHEIT");

        Conversion result = converterService.convertTemperature(conversion);

        assertNull(result.getResult());
    }
}

