package com.back;

public class Calc {
    public static int run(String expression) {
        String[] expressionBites = expression.split(" \\+ ");

        int num1=Integer.parseInt(expressionBites[0]);
        int num2=Integer.parseInt(expressionBites[1]);

        return num1+num2;
    }
}
