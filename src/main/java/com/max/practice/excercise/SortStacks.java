package com.max.practice.excercise;

import java.util.Stack;

public class SortStacks {

    public Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();

        while (!stack.isEmpty()) {
            Integer current = stack.pop();

            while (!result.isEmpty() && result.peek() > current) {
                stack.push(result.pop());
            }

            result.push(current);
        }

        return result;
    }
}
