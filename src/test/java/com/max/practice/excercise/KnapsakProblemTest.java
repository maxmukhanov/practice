package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class KnapsakProblemTest {
    private KnapsakProblem sut = new KnapsakProblem();

    @Test
    public void shouldReturnMaxValueFor50Knapsak() {
        assertThat(sut.maxAmount(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50)).isEqualTo(220);
    }

    @Test
    public void shouldReturnZeroWhenAnyItenCanFit() {
        assertThat(sut.maxAmount(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 5)).isEqualTo(0);
    }
}