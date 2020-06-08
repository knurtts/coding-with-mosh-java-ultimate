package com.codewithmosh;

public class IfStatements {

    static void main () {
        int temp = 32;
        if (temp > 30) {
            System.out.println("It's a hot day.\nDrink water!");
        } else if (temp > 20) {
            System.out.println("Beautiful day.");
        } else {
            System.out.println("Cold day.");
        }

        int income = 120_000;
        String className = income > 100_000 ? "First" : "Economy";
    }
}
