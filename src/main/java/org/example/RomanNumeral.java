package org.example;

import java.util.Arrays;

public enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XL(40), L(50), XC(90), C(100);

    private final int num;

    RomanNumeral(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static String toRoman(int number) {
        if (number <= 0 || number > 100) {
            throw new IllegalArgumentException("Число должно быть от 1 до 100");
        }

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

    public static RomanNumeral fromInt(int number) {
        for (RomanNumeral numeral : RomanNumeral.values()) {
            if (numeral.num == number) {
                return numeral;
            }
        }
        throw new IllegalArgumentException("Недопустимое значение для римской цифры: " + number);
    }
}
