package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class LookAndSayTest {
    private LookAndSay sut = new LookAndSay();

    @Test
    public void test1() {
        assertEquals("11", sut.lookAndSay("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenInputIsEmpty() {
        sut.lookAndSay("");
    }

    @Test
    public void test2() {
        assertEquals("3142131425", sut.lookAndSay("11122223455"));
    }
}