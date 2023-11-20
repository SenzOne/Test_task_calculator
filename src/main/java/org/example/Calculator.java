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

    public boolean containsOperator(String str) {
        return str.matches(".*[+\\-*/].*"); // Проверяем, содержит ли строка только римские цифры
    }


    public boolean canConvertToNumber(String a, String b) {
        try {
            Integer.parseInt(a);
            Integer.parseInt(b);
            return true; // Возвращаем true, если преобразование прошло успешно
        } catch (NumberFormatException e) {
            return false; // Возвращаем false в случае ошибки преобразования
        }
    }

    public boolean areBothEnums(String str1, String str2) {
        try {
            // Попытка получения объекта enum для обеих строк
            Enum.valueOf(RomanNumeral.class, str1);
            Enum.valueOf(RomanNumeral.class, str2);
            return true; // Если объект enum создан успешно для обеих строк, возвращаем true
        } catch (IllegalArgumentException e) {
            return false; // Если возникла ошибка создания объекта enum хотя бы для одной строки, возвращаем false
        }
    }


    public void calculate(){
        String[] inputArr = input.split(" ");
        if (canConvertToNumber(inputArr[0], inputArr[2]) && containsOperator(inputArr[1])){
            operator = inputArr[1].charAt(0);
            this.a =  Integer.parseInt(inputArr[0]);
            this.b =  Integer.parseInt(inputArr[2]);
            System.out.println(calculation(operator));

        } else if (areBothEnums(inputArr[0], inputArr[2]) && containsOperator(inputArr[1]) ){
            operator = inputArr[1].charAt(0);
            RomanNumeral romanNumeral = RomanNumeral.valueOf(inputArr[0]);
            RomanNumeral romanNumeral1 = RomanNumeral.valueOf(inputArr[2]);
            this.a = romanNumeral.getNum();
            this.b = romanNumeral1.getNum();
            System.out.println(calculation(operator));
        }
    }


//    public void getData1() {
//        // String input = prompt();
//        String[] inputArr = input.split(" ");
//
//        if (inputArr[0].charAt(0) == '-') {
//            try {
//                this.a = Integer.parseInt(inputArr[0]);
//            } catch (Exception e) {
//                System.out.println("Неверный символ " + inputArr[0]);
//            }
//
//        } else {
//            charA = inputArr[0].charAt(0);
//        }
//
//        operator = inputArr[1].charAt(0);
//
//        if (inputArr[2].charAt(0) == '-') {
//            this.b = Integer.parseInt(inputArr[2]);
//        } else {
//            charB = inputArr[2].charAt(0);
//        }
//    }


//    public String calculate() {
//        getData();
//        if (this.a != 0 && this.b != 0) {
//            return calculation(operator);
//        }
//        try {
//            if (Character.isDigit(charA) && Character.isDigit(charB)) {
//                this.a = Character.getNumericValue(charA);
//                this.b = Character.getNumericValue(charB);
//            } else if ((Character.isDigit(charA) ^ Character.isDigit(charB))) {
//                throw new Exception("Используются одновременно разные системы счисления");
//            } else {
//                RomanNumeral romanNumeral = RomanNumeral.valueOf(String.format("%s", charA));
//                this.a = romanNumeral.getNum();
//                this.b = romanNumeral.getNum();
//            }
//        } catch (Exception e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//        return calculation(operator);
//    }

    private String calculation(char operator) {
        return switch (operator) {
            case '+' -> sum(a, b);
            case '-' -> difference(a, b);
            case '/' -> division(a, b);
            case '*' -> multiplication(a, b);
            default -> null;
        };
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
        try {
            return String.format("%s", a / b);
        } catch (Exception e) {
            System.out.println("Ошибка " + e);
        }
        return null;
    }

//    public String prompt(){
//        System.out.println("Введи числа: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
}
