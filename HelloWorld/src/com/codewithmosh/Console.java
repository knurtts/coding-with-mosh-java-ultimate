package com.codewithmosh;

import java.util.Scanner;

public class Console {

    public static double readNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {

        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Enter a value between " + min + " and " + max);
            }
        }
        return value;
    }
}
