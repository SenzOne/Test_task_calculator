package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {
    private int a;
    private int b;

    public String calculate(){
        String input = prompt();
        String[] inputArr =  input.split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[2]);
        char operator =  inputArr[1].charAt(0);

        switch (operator){
            case '+': return sum(a, b);
            case '-': return difference(a, b);
            case '/': return multiplication(a, b);
            case '*': return division(a, b);
        }
        return null;
    }

    public String sum(int a, int b){
        return String.format("%s", a + b);
    }

    public String difference(int a, int b){
        return String.format("%s", a - b);
    }

    public String multiplication(int a, int b){
        return String.format("%s", a * b);
    }

    public String division(int a, int b){
        return String.format("%s", a / b);
    }

//    public String prompt(){
//        System.out.println("Введи числа: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }

    public String prompt(){
        return "5 + 6";
    }


}
