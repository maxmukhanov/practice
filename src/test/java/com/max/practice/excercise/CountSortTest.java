package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CountSortTest {
    private CountSort sut = new CountSort();

    @Test
    public void shouldSortCharsInString() {
        assertThat(sut.sort("bbbaacacc")).isEqualTo("aaabbbccc");
    }
}