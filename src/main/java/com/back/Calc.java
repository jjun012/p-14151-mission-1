package com.back;

public class Calc {

    public static int run(String expression) {
        expression = expression.replaceAll(" ","");

        int plus = expression.lastIndexOf("+");
        int minus = expression.lastIndexOf("-");

        if (plus != -1 && plus > minus) {
            String left = expression.substring(0, plus);
            String right = expression.substring(plus + 1);
            return run(left) + Integer.parseInt(right);
        }

        if  (minus != -1 && plus < minus) {
            String left = expression.substring(0, minus);
            String right = expression.substring(minus + 1);
            return run(left) - Integer.parseInt(right);
        }
        return Integer.parseInt(expression);
    }

//        String[] expressionBites;
//        int result = 0;
//        if (expression.contains(" + ")) {
//            expressionBites = expression.split(" \\+ ");
//            for (int i = 0; i < expressionBites.length; i++) {
//                result +=Integer.parseInt(expressionBites[i]);
//            }
//
//            return result;
//        }
//        else if (expression.contains(" - ")) {
//            expressionBites = expression.split(" \\- ");
//            int num1 = Integer.parseInt(expressionBites[0]);
//            int num2 = Integer.parseInt(expressionBites[1]);
//
//            return num1 - num2;
//        }
//        return 0;
//    }
}