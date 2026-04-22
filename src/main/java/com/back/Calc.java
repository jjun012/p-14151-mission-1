package com.back;



public class Calc {

    public static int run(String expression) {
        String[] expressionBites;

        if (expression.contains(" + ")) {
            expressionBites = expression.split(" \\+ ");
            int num1 = Integer.parseInt(expressionBites[0]);
            int num2 = Integer.parseInt(expressionBites[1]);
            int num3 = Integer.parseInt(expressionBites[2]);

            return num1 + num2 + num3;
        }
        else if (expression.contains(" - ")) {
            expressionBites = expression.split(" \\- ");
            int num1 = Integer.parseInt(expressionBites[0]);
            int num2 = Integer.parseInt(expressionBites[1]);

            return num1 - num2;
        }
        return 0;
    }
}