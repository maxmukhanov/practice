package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MissingNumberTest {
    private MissingNumber sut = new MissingNumber();

    @Test
    public void shouldFindMissingNumber() {
        assertThat(sut.missingNumber(new int[]{0, 1, 3, 4})).isEqualTo(2);
    }
}