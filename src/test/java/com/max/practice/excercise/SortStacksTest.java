package com.max.practice.excercise;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class SortStacksTest {
    private SortStacks sut = new SortStacks();

    @Test
    public void shouldSortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        Stack<Integer> actual = sut.sort(stack);
        assertThat(actual.toArray()).containsExactly(1, 2, 3, 4, 5);
    }
}