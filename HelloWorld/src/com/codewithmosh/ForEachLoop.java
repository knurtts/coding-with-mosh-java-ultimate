package com.codewithmosh;

public class ForEachLoop {

    static void main(String[] args) {
        String[] fruits = {"apple", "mango", "orange"};

        for (int i = fruits.length; i > 0; i++) {
            System.out.println(fruits[i]);
        }

        // no access to index in this loop, but use as long as you don't need the index
        for (String fruit : fruits)
            System.out.println(fruit);
    }
}
