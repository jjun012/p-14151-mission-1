package com.back;



public class Calc {

    public static int run(String expression) {
        String[] expressionBites;
        int result = 0;
        if (expression.contains(" + ")) {
            expressionBites = expression.split(" \\+ ");
            for (int i = 0; i < expressionBites.length; i++) {
                result +=Integer.parseInt(expressionBites[i]);
            }

            return result;
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