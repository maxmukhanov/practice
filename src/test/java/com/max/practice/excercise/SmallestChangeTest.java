package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SmallestChangeTest {

    SmallestChange sut = new SmallestChange();

    @Test
    public void shouldReturn6ForAmount67() {
        assertThat(sut.smallestChange(67)).isEqualTo(6);

    }
}