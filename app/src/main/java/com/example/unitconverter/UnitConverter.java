package com.example.unitconverter;

public class UnitConverter {
    public static double convert(String from, String to, double value) {
        if (from.equals(to)) return value; // If same unit, return the value unchanged.

        // Length Conversions
        switch (from) {
            case "Inch": value *= 2.54; break;  // Convert inches to cm
            case "Foot": value *= 30.48; break; // Convert feet to cm
            case "Yard": value *= 91.44; break; // Convert yards to cm
            case "Mile": value *= 1.60934 * 100000; break; // Convert miles to cm (1.60934 km to cm)
        }

        switch (to) {
            case "Inch": return value / 2.54;
            case "Foot": return value / 30.48;
            case "Yard": return value / 91.44;
            case "Mile": return value / (1.60934 * 100000);
        }

        // Weight Conversions
        switch (from) {
            case "Pound": value *= 0.453592; break; // Convert pounds to kg
            case "Ounce": value *= 28.3495 / 1000; break; // Convert ounces to kg
            case "Ton": value *= 907.185; break; // Convert tons to kg
        }

        switch (to) {
            case "Pound": return value / 0.453592;
            case "Ounce": return value / (28.3495 / 1000);
            case "Ton": return value / 907.185;
        }

        // Temperature Conversions
        if (from.equals("Celsius") && to.equals("Fahrenheit")) return (value * 1.8) + 32;
        if (from.equals("Fahrenheit") && to.equals("Celsius")) return (value - 32) / 1.8;
        if (from.equals("Celsius") && to.equals("Kelvin")) return value + 273.15;
        if (from.equals("Kelvin") && to.equals("Celsius")) return value - 273.15;

        return Double.NaN; // Return NaN if conversion is invalid
    }
}

