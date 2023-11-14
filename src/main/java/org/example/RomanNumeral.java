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
}
