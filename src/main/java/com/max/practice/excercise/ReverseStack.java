package com.max.practice.excercise;

import java.util.Stack;

public class ReverseStack {

  public void reverse(Stack<Integer> stack) {
    if (stack.isEmpty()) return;

    Integer temp = stack.pop();
    reverse(stack);
    insertAtBottom(stack, temp);
  }

  private void insertAtBottom(Stack<Integer> stack, Integer value) {
    if (stack.isEmpty()) {
      stack.push(value);
      return;
    }

    Integer temp = stack.pop();
    insertAtBottom(stack, value);
    stack.push(temp);

  }


}
