package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SumTwoWithoutArithmeticTest {
    private SumTwoWithoutArithmetic sut = new SumTwoWithoutArithmetic();

    @Test
    public void shouldSumTwoPositive() {
        assertThat(sut.sum(4, 7)).isEqualTo(11);
    }

    @Test
    public void shouldSumTwoPositiveAndNegarive() {
        assertThat(sut.sum(4, -5)).isEqualTo(-1);
    }

    @Test
    public void shouldSumTwoNegative() {
        assertThat(sut.sum(-3, -9)).isEqualTo(-12);
    }

    @Test
    public void shouldSumTwoOneIsZero() {
        assertThat(sut.sum(0, 7)).isEqualTo(7);
    }
}