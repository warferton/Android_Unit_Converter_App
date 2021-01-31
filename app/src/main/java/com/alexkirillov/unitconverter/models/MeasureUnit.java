package com.alexkirillov.unitconverter.models;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class MeasureUnit {

    private String unitName;

    private Map<String, Double> poundConvertRates = new HashMap<String, Double>(){{

        put("Kilograms", 0.4535924);
        put("Ounces", 16.0);
        put("Grams", 453.5924);

    }};

    private Map<String, Double> ounceConvertRates = new HashMap<String, Double>(){{

        put("Kilograms", 0.02834952);
        put("Pounds", 0.0625);
        put("Grams", 28.34952);

    }};

    private Map<String, Double> kilogramConvertRates = new HashMap<String, Double>(){{

        put("Pounds", 2.204623);
        put("Ounces", 35.27396);
        put("Grams", 1000.0);

    }};

    private Map<String, Double> gramConvertRates = new HashMap<String, Double>(){{

        put("Kilograms", 0.001);
        put("Ounces", 0.03527396);
        put("Pounds", 0.002204623);

    }};


    public MeasureUnit(String unitName)  {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public double convertPounds(double value, String final_unit_name){
        double convert_index = this.poundConvertRates.get(final_unit_name);
        return value * convert_index;
    }


    public double convertKilograms(double value, String final_unit_name){
        double convert_index = this.kilogramConvertRates.get(final_unit_name);
        return value * convert_index;
    }


    public double convertOunces(double value, String final_unit_name){
        double convert_index = this.ounceConvertRates.get(final_unit_name);
        return value * convert_index;
    }

    public double convertGrams(double value, String final_unit_name){
        double convert_index = this.gramConvertRates.get(final_unit_name);
        return value * convert_index;
    }

    @NonNull
    @Override
    public String toString() {
        return unitName;
    }
}
