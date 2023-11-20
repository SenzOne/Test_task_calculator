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



    public Calculator() {
        this.input = prompt();
    }
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
    private boolean containsOperator(String str) {
        return str.matches(".*[+\\-*/].*");
    }


    /**
     * Проверяет, можно ли преобразовать строки a и b в числа от 1 до 10.
     * @param a Первая строка для проверки.
     * @param b Вторая строка для проверки.
     * @return true, если обе строки можно преобразовать в числа от 1 до 10, иначе false.
     */
    private boolean canConvertToNumber(String a, String b) {
        try {
            int numberA = Integer.parseInt(a);
            int numberB = Integer.parseInt(b);
            return (numberA <= 10) && (numberB <= 10);
        } catch (NumberFormatException e) {
            // System.out.println("Числа должны быть меньше 10");
            return false;
        }
    }


    /**
     * Проверяет, можно ли преобразовать строки str1 и str2 в римские цифры от I до X (1 до 10).
     * @param str1 Первая строка для проверки.
     * @param str2 Вторая строка для проверки.
     * @return true, если обе строки могут быть преобразованы в римские цифры от I до X (1 до 10), иначе false.
     */
    private boolean areBothEnums(String str1, String str2) {
        try {
            RomanNumeral romanNumeral1 = Enum.valueOf(RomanNumeral.class, str1);
            RomanNumeral romanNumeral2 = Enum.valueOf(RomanNumeral.class, str2);

            return (romanNumeral1.getNum() <= 10) && (romanNumeral2.getNum() <= 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Числа должны быть меньше 10");
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

        if (inputArr.length != 3) {
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");
        }

        char operator = inputArr[1].charAt(0);

        if (!containsOperator(inputArr[1])) {
            throw new IllegalArgumentException("Отсутствует оператор");
        }

        if (canConvertToNumber(inputArr[0], inputArr[2]) && containsOperator(inputArr[1])){
            this.a =  Integer.parseInt(inputArr[0]);
            this.b =  Integer.parseInt(inputArr[2]);
            System.out.println(calculation(operator));

        } else if (areBothEnums(inputArr[0], inputArr[2]) && containsOperator(inputArr[1]) ){
            RomanNumeral romanNumeral = RomanNumeral.valueOf(inputArr[0]);
            RomanNumeral romanNumeral1 = RomanNumeral.valueOf(inputArr[2]);
            this.a = romanNumeral.getNum();
            this.b = romanNumeral1.getNum();
            String res = calculation(operator);
            try {
                System.out.println(RomanNumeral.toRoman(Integer.parseInt(res)));
            } catch (Exception e){
                System.out.println("В римской системе нет отрицательных чисел");
            }
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }
    }


    /**
     * Выполняет операцию над двумя числами в зависимости от переданного оператора.
     * @param operator Знак операции (+, -, *, /).
     * @return Результат операции над числами в виде строки.
     * @throws IllegalArgumentException если передан неизвестный оператор.
     */
    private String calculation(char operator) {
        return switch (operator) {
            case '+' -> sum(a, b);
            case '-' -> difference(a, b);
            case '/' -> division(a, b);
            case '*' -> multiplication(a, b);
            default ->  throw new IllegalArgumentException("Неизвестный оператор: " + operator);
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


    /**
     * Выполняет деление двух чисел a на b.
     * @param a Делимое число.
     * @param b Делитель.
     * @return Результат деления a на b в виде строки.
     * @throws ArithmeticException если делитель равен нулю.
     */
    private String division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return String.format("%s", a / b);
    }


    /**
     * Метод prompt запрашивает ввод пользовательской строки с числами.
     * @return Возвращает введенную пользователем строку с числами.
     */
    private String prompt(){
        System.out.println("Введи числа: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
