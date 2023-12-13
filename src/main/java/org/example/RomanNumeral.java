package org.example;

import java.util.Arrays;


/**
 * Перечисление RomanNumeral представляет римские числа от I до C (1 до 100).
 */
enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private final int num;

    /**
     * Конструктор для римских цифр с их числовым эквивалентом.
     * @param num Числовое значение римской цифры.
     */
    RomanNumeral(int num) {
        this.num = num;
    }

    /**
     * Получает числовое значение римской цифры.
     * @return Числовое значение римской цифры.
     */
    public int getNum() {
        return num;
    }


    /**
     * Преобразует целое число в его римское представление.
     * @param number Число для преобразования в римскую цифру (от 1 до 100).
     * @return Римское представление числа.
     * @throws IllegalArgumentException если число не входит в диапазон от 1 до 100.
     */
    public static String toRoman(int number) {
        if (number <= 0 || number > 100) {
            throw new IllegalArgumentException("Число должно быть от 1 до 100");
        }

        // Получение значений римских цифр из перечисления RomanNumeral
        RomanNumeral[] values = RomanNumeral.values();
        int i = values.length - 1; //[C, XC, L, XL, X]
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i >= 0) {
            if (values[i].getNum() <= number) {
                // System.out.println(values[i].getNum());
                sb.append(values[i]);
                number -= values[i].getNum();
            } else {
                i--;
            }
        }
        return sb.toString();
    }
}
