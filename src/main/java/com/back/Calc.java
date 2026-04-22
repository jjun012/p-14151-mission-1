package com.back;

public class Calc {

    public static int run(String expression) {
        expression = expression.replaceAll(" ","");
        if (expression.startsWith("(") && expression.endsWith(")")) {
            if (isFull(expression)){
                return run(expression.substring(1, expression.length()-1));
            }
        }
        if (expression.startsWith("-")) {
            if (expression.charAt(1)=='('){
                return - run(expression.substring(1));
            }
        }
        int plus = findLast(expression,'+');
        int minus = findLast(expression,'-');
        int mul =  findLast(expression,'*');

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
    private static boolean isFull(String exp) {
        int count = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                count++;
            }
            else if (exp.charAt(i) == ')') {
                count--;
            }
            if (count == 0 && i< exp.length() -1) {
                return false;
            }
        }
        return count == 0;
    }
    private static int findLast(String exp, char find) {
        int brackets = 0;
        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                brackets++;
            } else if (ch ==')') {
                brackets--;
            } else if (brackets == 0 && ch == find) {
                return i;
            }
        }
        return -1;
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