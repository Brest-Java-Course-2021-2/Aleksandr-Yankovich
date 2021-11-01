package com.epam.brest.calc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalcImplTest {

    Calc calc = new CalcImpl();

    @Test
    void testHandleMethod() {
        BigDecimal weight = new BigDecimal("10");
        BigDecimal weightPrice = new BigDecimal("10");
        BigDecimal length = new BigDecimal("10");
        BigDecimal lengthPrice = new BigDecimal("10");

        assertNotNull(calc);
        assertEquals(new BigDecimal(200), calc.handle(weight, weightPrice, length, lengthPrice));
    }

    @Test
    void testHandleMethodWithNullParameters() {
        assertNotNull(calc);
        assertThrows(IllegalArgumentException.class, () ->
                calc.handle(null, null, null, null));
    }
}