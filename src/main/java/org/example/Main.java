package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator("I + I");
        // calculator1.getData();
        calculator1.calculate();

        Calculator calculator2 = new Calculator("-10 / -2");
        calculator2.calculate();

        Calculator calculator3 = new Calculator("III + 3");
        calculator3.calculate();

        Calculator calculator4 = new Calculator("-ы + 1");
        calculator4.calculate();


    }
}