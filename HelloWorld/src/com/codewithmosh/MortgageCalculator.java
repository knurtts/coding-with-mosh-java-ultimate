package com.codewithmosh;

import java.text.NumberFormat;

public class MortgageCalculator {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    static void main() {

        int principal = (int)(Console.readNumber("Principal: ", 1000, 1_000_000));
        float annualInterest = (float)(Console.readNumber("Annual Interest Rate: ", 0, 30));
        byte years = (byte)(Console.readNumber("Period (Years): ", 1, 30));

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("\nMORTGAGE\n________\nMonthly Payment: " + formattedMortgage);

        createPaymentSchedule(principal, annualInterest, years);
    }

    public static double calculateRemainingBalance(int principal, float annualInterest, byte years, short numberOfCompletedPayments) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfCompletedPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float payments = (short)(years * MONTHS_IN_YEAR);

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, payments) / (Math.pow(1 + monthlyInterest, payments) - 1));
    }

    public static void createPaymentSchedule(int principal, float annualInterest, byte years) {

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        System.out.println("\nPAYMENT SCHEDULE\n________________");
        for (short month = 1; month <= numberOfPayments; month++) {

            double balance = calculateRemainingBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

}
