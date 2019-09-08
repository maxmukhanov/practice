package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BinaryArithmeticTest {

    private BinaryArithmetic sut = new BinaryArithmetic();

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

    @Test
    public void shouldReturnPositiveProductWhenMultiplyTwoPositives() {
        assertThat(sut.multiply(5, 4)).isEqualTo(20);
    }

    @Test
    public void shouldReturnNegativeProductWhenMultiplyPositiveToNegative() {
        assertThat(sut.multiply(5, -4)).isEqualTo(-20);
    }

    @Test
    public void shouldReturnNegativeProductWhenMultiplyNegativeToPositive() {
        assertThat(sut.multiply(-5, 4)).isEqualTo(-20);
    }

    @Test
    public void shouldReturnPositiveProductWhenMultiplyTwoNegatives() {
        assertThat(sut.multiply(-5, -4)).isEqualTo(20);
    }

    @Test
    public void shouldReturnZeroProductWhenMultiplyOnZero() {
        assertThat(sut.multiply(-5, 0)).isEqualTo(0);
    }

    @Test
    public void shouldReturnZeroProductWhenMultiplyTwoZeros() {
        assertThat(sut.multiply(0, 0)).isEqualTo(0);
    }

}