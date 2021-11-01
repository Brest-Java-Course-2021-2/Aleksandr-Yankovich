package com.epam.brest.calc;

import java.math.BigDecimal;

public class CalcImpl implements Calc {

    @Override
    public BigDecimal handle(BigDecimal weight, BigDecimal pricePerKg, BigDecimal length, BigDecimal pricePerKm) {
        if (weight == null || pricePerKg == null || length == null || pricePerKm == null) {
            throw new IllegalArgumentException("Parameter should not be NULL");
        }
        return weight.multiply(pricePerKg).add(length.multiply(pricePerKm));
    }
}
