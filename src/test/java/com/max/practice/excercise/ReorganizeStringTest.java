package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorganizeStringTest {
    ReorganizeString sut = new ReorganizeString();

    @Test
    public void test1() {
        String actual = sut.reorganizeString("vvvlo");

        assertAdjacentNotTheSame(actual);
    }

    @Test
    public void test2() {
        String actual = sut.reorganizeString("aab");

        assertAdjacentNotTheSame(actual);
    }

    @Test
    public void test3() {
        String actual = sut.reorganizeString("aaab");

        assertEquals("", actual);
    }

    private void assertAdjacentNotTheSame(String actual) {
        if (actual == null || actual.length() < 3) return;

        for (int i = 1; i < actual.length(); i++) {
            if (actual.charAt(i - 1) == actual.charAt(i)) {
                throw new AssertionError("Adjacent are the same for " + actual);
            }
        }
    }
}