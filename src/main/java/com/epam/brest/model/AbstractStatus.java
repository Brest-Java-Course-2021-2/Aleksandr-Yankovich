package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractStatus implements Status {

    Scanner scanner;
    Map<Integer, BigDecimal> pricePerKgMap;
    Map<Integer, BigDecimal> pricePerKmMap;

}
