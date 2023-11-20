package org.example;

public enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5);

    private int num;

    RomanNumeral(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
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
