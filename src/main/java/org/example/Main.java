package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator("VI + V");
        calculator1.calculate();

        Calculator calculator2 = new Calculator("10 + 9");
        calculator2.calculate();

        Calculator calculator3 = new Calculator("10 + 9");
        calculator3.calculate();
    }
}