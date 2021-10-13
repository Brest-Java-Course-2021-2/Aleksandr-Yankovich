package com.epam.brest;

import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight, pricePerKg, length, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                weight = getValueFromCon(scanner, "Enter weight:");
                pricePerKg = getValueFromCon(scanner, "Enter pricePerKg:");
                length = getValueFromCon(scanner, "Enter length:");
                pricePerKm = getValueFromCon(scanner, "Enter pricePerKm:");
                System.out.println("Result:" + new CalcImpl().handle(weight, pricePerKg, length, pricePerKm));
                System.out.println("Enter 'q' for exit or 'c' to continue:");
            } while (scanner.next().equals("c"));
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue;
        System.out.print(outputMessage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }
}
