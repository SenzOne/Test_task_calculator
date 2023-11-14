package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {
    private final String input;
    private int a;
    private int b;
    private char operator;
    private char charA;
    private char charB;


    public Calculator(String input) {
        this.input = input;
    }

    private void getData() {
        //String input = prompt();
        String[] inputArr = input.split(" ");

        charA = inputArr[0].charAt(0);
        operator = inputArr[1].charAt(0);
        charB = inputArr[2].charAt(0);
    }

    public String calculate() {
        getData();
        try {
            if (Character.isDigit(charA) && Character.isDigit(charB)) {
                this.a = Character.getNumericValue(charA);
                this.b = Character.getNumericValue(charB);
            } else if ((Character.isDigit(charA) ^ Character.isDigit(charB))) {
                throw new Exception("Используются одновременно разные системы счисления");
            } else {
                RomanNumeral romanNumeral = RomanNumeral.valueOf(String.format("%s", charA));
                this.a = romanNumeral.getNum();
                this.b = romanNumeral.getNum();
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

    private String sum(int a, int b) {
        return String.format("%s", a + b);
    }

    private String difference(int a, int b) {
        return String.format("%s", a - b);
    }

    private String multiplication(int a, int b) {
        return String.format("%s", a * b);
    }

    private String division(int a, int b) {
        return String.format("%s", a / b);
    }

//    public String prompt(){
//        System.out.println("Введи числа: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
}
