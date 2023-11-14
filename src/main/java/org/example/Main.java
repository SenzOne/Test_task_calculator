package org.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator("I + I");
        System.out.println(calculator1.calculate());

        Calculator calculator2 = new Calculator("2 + 2");
        System.out.println(calculator2.calculate());

        Calculator calculator3 = new Calculator("III + 3");
        System.out.println(calculator3.calculate());

        Calculator calculator4 = new Calculator("IV + IV");
        System.out.println(calculator4.calculate());


    }
}