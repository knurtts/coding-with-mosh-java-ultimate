package com.codewithmosh;

import java.util.Scanner;

public class DoWhileAndWhileLoops {

    static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
//          while loop evaluates before code executes
        while (!input.equals("quit")) {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }

//        do while loop evaluates after code executes. this code will always execute at least once
        do {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while (!input.equals("quit"));

//        if using this while true loop always have a break statement to avoid infinite loops
        while (true) {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break;
        }
    }
}
