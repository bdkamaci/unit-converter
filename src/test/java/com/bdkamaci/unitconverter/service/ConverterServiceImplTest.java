package com.bdkamaci.unitconverter.service;

import com.bdkamaci.unitconverter.enums.LengthUnit;
import com.bdkamaci.unitconverter.enums.TemperatureUnit;
import com.bdkamaci.unitconverter.enums.WeightUnit;
import com.bdkamaci.unitconverter.model.Conversion;
import com.bdkamaci.unitconverter.service.impl.ConverterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class ConverterServiceImplTest {

    private ConverterServiceImpl converterService;

    @BeforeEach
    void setUp() {
        converterService = new ConverterServiceImpl();
    }

    @Test
    void testConvertLength() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(100.0);
        conversion.setFromUnit("METER");
        conversion.setToUnit("KILOMETER");

        LengthUnit mockFromUnit = Mockito.mock(LengthUnit.class);
        LengthUnit mockToUnit = Mockito.mock(LengthUnit.class);

        Mockito.when(mockFromUnit.toMeters(100.0)).thenReturn(100.0);
        Mockito.when(mockToUnit.fromMeters(100.0)).thenReturn(0.1);

        Conversion result = converterService.convertLength(conversion);

        assertNotNull(result);
        assertEquals(0.1, result.getResult());
    }

    @Test
    void testConvertWeight() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(5000.0);
        conversion.setFromUnit("GRAM");
        conversion.setToUnit("KILOGRAM");

        WeightUnit mockFromUnit = Mockito.mock(WeightUnit.class);
        WeightUnit mockToUnit = Mockito.mock(WeightUnit.class);

        Mockito.when(mockFromUnit.toKilograms(5000.0)).thenReturn(5.0);
        Mockito.when(mockToUnit.fromKilograms(5.0)).thenReturn(5.0);

        Conversion result = converterService.convertWeight(conversion);

        assertNotNull(result);
        assertEquals(5.0, result.getResult());
    }

    @Test
    void testConvertTemperature() {
        Conversion conversion = new Conversion();
        conversion.setInputValue(100.0);
        conversion.setFromUnit("CELSIUS");
        conversion.setToUnit("FAHRENHEIT");

        TemperatureUnit mockFromUnit = Mockito.mock(TemperatureUnit.class);
        TemperatureUnit mockToUnit = Mockito.mock(TemperatureUnit.class);

        Mockito.when(mockFromUnit.convert(100.0, mockToUnit)).thenReturn(212.0);

        Conversion result = converterService.convertTemperature(conversion);

        assertNotNull(result);
        assertEquals(212.0, result.getResult());
    }
}
