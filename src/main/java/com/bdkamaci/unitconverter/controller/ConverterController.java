package com.bdkamaci.unitconverter.controller;

import com.bdkamaci.unitconverter.enums.LengthUnit;
import com.bdkamaci.unitconverter.enums.TemperatureUnit;
import com.bdkamaci.unitconverter.enums.WeightUnit;
import com.bdkamaci.unitconverter.model.Conversion;
import com.bdkamaci.unitconverter.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ConverterController {
    private final ConverterService converterService;

    @GetMapping("/length")
    public String lengthConverter(Model model) {
        model.addAttribute("conversion", new Conversion());
        model.addAttribute("lengthUnits", LengthUnit.values());
        return "length";
    }

    @PostMapping("/length")
    public String convertLength(@ModelAttribute Conversion conversion, Model model) {
        conversion.setConversionType("length");
        Conversion result = converterService.convertLength(conversion);
        model.addAttribute("conversion", result);
        model.addAttribute("lengthUnits", LengthUnit.values());
        return "length";
    }

    @GetMapping("/weight")
    public String weightConverter(Model model) {
        model.addAttribute("conversion", new Conversion());
        model.addAttribute("weightUnits", WeightUnit.values());
        return "weight";
    }

    @PostMapping("/weight")
    public String convertWeight(@ModelAttribute Conversion conversion, Model model) {
        conversion.setConversionType("weight");
        Conversion result = converterService.convertWeight(conversion);
        model.addAttribute("conversion", result);
        model.addAttribute("weightUnits", WeightUnit.values());
        return "weight";
    }

    @GetMapping("/temperature")
    public String temperatureConverter(Model model) {
        model.addAttribute("conversion", new Conversion());
        model.addAttribute("temperatureUnits", TemperatureUnit.values());
        return "temperature";
    }

    @PostMapping("/temperature")
    public String convertTemperature(@ModelAttribute Conversion conversion, Model model) {
        conversion.setConversionType("temperature");
        Conversion result = converterService.convertTemperature(conversion);
        model.addAttribute("conversion", result);
        model.addAttribute("temperatureUnits", TemperatureUnit.values());
        return "temperature";
    }
}
