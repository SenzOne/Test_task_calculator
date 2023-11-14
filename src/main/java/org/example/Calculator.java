package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {
    RomanNumeral romanNumeral;
    private String input;
    private int a;
    private int b;

    public Calculator(String input) {
        this.input = input;
    }

    public String calculate() {
        //String input = prompt();
        String[] inputArr = input.split(" ");

        char charA = inputArr[0].charAt(0);
        char operator = inputArr[1].charAt(0);
        char charB = inputArr[2].charAt(0);

        try {
            if (Character.isDigit(charA)) {
                this.a = Character.getNumericValue(charA);
            } else {
                RomanNumeral romanNumeral1 = RomanNumeral.valueOf(inputArr[0]);
                this.a = romanNumeral1.getNum();
            }

            if (Character.isDigit(charB)) {
                this.b = Character.getNumericValue(charB);
            } else {
                RomanNumeral romanNumeral1 = RomanNumeral.valueOf(inputArr[0]);
                this.b = romanNumeral1.getNum();
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }


        switch (operator) {
            case '+':
                return sum(a, b);
            case '-':
                return difference(a, b);
            case '/':
                return multiplication(a, b);
            case '*':
                return division(a, b);
        }
        return null;
    }

    public String sum(int a, int b) {
        return String.format("%s", a + b);
    }

    public String difference(int a, int b) {
        return String.format("%s", a - b);
    }

    public String multiplication(int a, int b) {
        return String.format("%s", a * b);
    }

    public String division(int a, int b) {
        return String.format("%s", a / b);
    }

//    public String prompt(){
//        System.out.println("Введи числа: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
}
