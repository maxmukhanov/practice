package com.max.practice.excercise;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class ReverseStackTest {
  private ReverseStack sut = new ReverseStack();

  @Test
  public void shouldReverseStack() {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    sut.reverse(stack);
    assertThat(stack).hasSize(4);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(4);
  }
}