package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Класс Calculator выполняет математические операции как для арабских, так и для римских чисел.
 */
public class Calculator {
    // Поля класса
    private final String input;
    private int a;
    private int b;


    /**
     * Конструктор класса Calculator.
     * @param input Строка с математическим выражением.
     */
    public Calculator(String input) {
        this.input = input;
    }

    /**
     * Метод containsOperator проверяет наличие оператора в строке.
     * @param str Строка для проверки.
     * @return Возвращает true, если строка содержит оператор (+, -, *, /), иначе false.
     */
    public boolean containsOperator(String str) {
        return str.matches(".*[+\\-*/].*");
    }


    /**
     * Метод canConvertToNumber проверяет возможность преобразования строк в числа.
     * @param a Строка с числом a.
     * @param b Строка с числом b.
     * @return Возвращает true, если обе строки могут быть преобразованы в числа, иначе false.
     */
    public boolean canConvertToNumber(String a, String b) {
        try {
            Integer.parseInt(a);
            Integer.parseInt(b);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    /**
     * Метод areBothEnums проверяет, являются ли обе строки римскими числами (перечисления RomanNumeral).
     * @param str1 Первая строка для проверки.
     * @param str2 Вторая строка для проверки.
     * @return Возвращает true, если обе строки являются римскими числами, иначе false.
     */
    public boolean areBothEnums(String str1, String str2) {
        try {

            Enum.valueOf(RomanNumeral.class, str1);
            Enum.valueOf(RomanNumeral.class, str2);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    /**
     * Метод calculate анализирует входную строку и выполняет операцию над числами.
     * Поддерживаются как арабские, так и римские числа.
     * @throws IllegalArgumentException выбрасывает исключение, если введены недопустимые значения или оператор.
     */
    public void calculate(){
        String[] inputArr = input.split(" ");
        char operator;
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
            String res = calculation(operator);
            System.out.println(RomanNumeral.toRoman(Integer.parseInt(res)));
        }
    }


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
