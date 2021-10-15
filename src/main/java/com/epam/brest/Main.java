package com.epam.brest;

import com.epam.brest.calc.CalcImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigDecimal weight;
        BigDecimal length;
        BigDecimal pricePerKg;
        BigDecimal pricePerKm;

        List<BigDecimal> pricePerKgSet = new ArrayList<>();
        List<BigDecimal> pricePerKmSet = new ArrayList<>();

        Properties property = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);

            pricePerKgSet.add(new BigDecimal(property.getProperty("pricePerKg_10")));
            pricePerKgSet.add(new BigDecimal(property.getProperty("pricePerKg_20")));
            pricePerKgSet.add(new BigDecimal(property.getProperty("pricePerKg_default")));

            pricePerKmSet.add(new BigDecimal(property.getProperty("pricePerKm_10")));
            pricePerKmSet.add(new BigDecimal(property.getProperty("pricePerKm_20")));
            pricePerKmSet.add(new BigDecimal(property.getProperty("pricePerKm_default")));

            Scanner scanner = new Scanner(System.in);
            do {
                weight = getValueFromCon(scanner, "Enter weight:");
                length = getValueFromCon(scanner, "Enter length:");

                pricePerKg = getValueFromArray(pricePerKgSet, weight);
                pricePerKm = getValueFromArray(pricePerKmSet, length);

                System.out.println("Result:" + new CalcImpl().handle(weight, pricePerKg, length, pricePerKm));
                System.out.println("Enter 'q' for exit or 'c' to continue:");
            } while (scanner.next().equals("c"));

        } catch (NumberFormatException numberFormatException) {
            System.err.println("Not correct entered format!");
        } catch (IOException e) {
            System.err.println("ERROR: Something went wrong!");
        }


    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue;
        System.out.print(outputMessage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }

    private static BigDecimal getValueFromArray(List<BigDecimal> array, BigDecimal parameter) {
        if (parameter.doubleValue() < 10)
            return array.get(0);
        else if (parameter.doubleValue() > 20)
            return array.get(2);
        else
            return array.get(1);
    }
}
