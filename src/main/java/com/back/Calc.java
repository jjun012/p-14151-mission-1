package com.back;

public class Calc {

    public static int run(String expression) {
        expression = expression.replaceAll(" ","");
        expression = expression.replaceAll("[\\(\\)]","");

        int plus = expression.lastIndexOf("+");
        int minus = expression.lastIndexOf("-");
        int mul =  expression.lastIndexOf("*");

        if (plus != -1 && plus > minus) {
            String left = expression.substring(0, plus);
            String right = expression.substring(plus + 1);
            return run(left) + run(right);
        }

        if  (minus != -1 && plus < minus) {
            boolean isOperator = minus >0 && Character.isDigit(expression.charAt(minus - 1));
            if (isOperator) {
                String left = expression.substring(0, minus);
                String right = expression.substring(minus + 1);
                return run(left) - run(right);
            }
        }
        if (mul != -1){
            String left = expression.substring(0, mul);
            String right = expression.substring(mul + 1);
            return run(left) * run(right);
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