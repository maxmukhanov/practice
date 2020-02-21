package com.max.practice.excercise;

import java.util.Stack;

public class MathExpressionEvaluator {

    public int eval(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch >= '0' && ch <= '9') {
                StringBuilder sb = new StringBuilder();
                while (ch >= '0' && ch <= '9' && i < expression.length()) {
                    sb.append(ch);

                    i++;
                    if (i < expression.length()) ch = expression.charAt(i);
                }

                values.push(Integer.valueOf(sb.toString()));
            }

            if (ch == '(') {
                operations.push(ch);
            } else if (ch == ')') {
                while (operations.peek() != '(') {
                    int result = applyOperation(values.pop(), values.pop(), operations.pop());
                    values.push(result);
                }
                operations.pop();
            } else if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^') {
                while (!operations.isEmpty() && higherPriority(ch, operations.peek())) {
                    int result = applyOperation(values.pop(), values.pop(), operations.pop());
                    values.push(result);
                }
                operations.push(ch);
            }
        }

        while (!operations.isEmpty()) {
            int result = applyOperation(values.pop(), values.pop(), operations.pop());
            values.push(result);
        }

        return values.pop();
    }

    private boolean higherPriority(char operator, char prev) {
        if (prev == '(' || prev == ')') return false;
        if ((operator == '*' || operator == '/') && (prev == '+' || prev == '-')) return false;
        if (prev == '^' && operator != '^') return true;
        return true;
    }

    private int applyOperation(Integer op1, Integer op2, char operation) {
        switch (operation) {
            case '+':
                return op2 + op1;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                return op2 / op1;
            case '^':
                return (int) Math.pow(op2, op1);
                default:
                    throw new IllegalArgumentException("Unknown operation : " + operation);
        }
    }
}
