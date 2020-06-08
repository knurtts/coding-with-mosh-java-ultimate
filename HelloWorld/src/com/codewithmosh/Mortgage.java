package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;
    private int principal;
    private float annualInterest = -1;
    private byte years = 0;
    private float monthlyInterest;
    private float numberOfPayments;
    private double mortgage = -99;

    public void calculateMortgage() {
        setPrincipal((int) Console.readNumber("Principal: ",1000,1_000_000));
        setAnnualInterest((float) Console.readNumber("Annual Interest Rate: ",0,30));
        setYears((byte) Console.readNumber("Period (Years): ", 1, 30));
        setMonthlyInterest();
        setNumberOfPayments();

        double mortgagePayment = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        setMortgage(mortgagePayment);

        System.out.println("\nMORTGAGE\n________\nMonthly Payment: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public void createPaymentSchedule() {
        if (mortgage == -99)
            System.out.println("$0.00");

        System.out.println("\nPAYMENT SCHEDULE\n________________");
        for (int month = 1; month <= numberOfPayments; month++) {
            double balance = calculateRemainingBalance((short) month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public double calculateRemainingBalance(short numberOfCompletedPayments) {
        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfCompletedPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    private int getPrincipal() {
        return principal;
    }

    private void setPrincipal(int principal) {
        if (principal < 1000 || principal > 1_000_000)
            throw new IllegalArgumentException("principal must be between 1,000 and 1,000,000");

        this.principal = principal;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    private byte getYears() {
        return years;
    }

    private void setYears(byte years) {
        if (years < 1 || years > 30)
            throw new IllegalArgumentException("years must be between 1 and 30");
        this.years = years;
    }

    private float getMonthlyInterest() {
        return monthlyInterest;
    }

    private void setMonthlyInterest() {
        if (this.annualInterest == -1)
            throw new IllegalArgumentException("you must set annualInterest first before setting monthlyInterest");

        this.monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private float getNumberOfPayments() {
        return numberOfPayments;
    }

    private void setNumberOfPayments() {
        if (years == 0)
            throw new IllegalArgumentException("you must set the years variable before setting numberOfPayments");
        this.numberOfPayments = years * MONTHS_IN_YEAR;
    }

    private double getMortgage() {
        return mortgage;
    }

    private void setMortgage(double mortgage) {
        this.mortgage = mortgage;
    }
}
