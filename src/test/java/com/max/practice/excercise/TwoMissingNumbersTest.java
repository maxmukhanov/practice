package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class TwoMissingNumbersTest {
    private TwoMissingNumbers sut = new TwoMissingNumbers();

    @Test
    public void shouldFindTwoMissingNumber() {
        assertThat(sut.missingNumbers(new int[]{2, 5, 3})).containsOnly(1, 4);
    }
}