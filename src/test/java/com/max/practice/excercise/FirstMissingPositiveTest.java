package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {

    FirstMissingPositive sut = new FirstMissingPositive();

    @Test
    public void test1() {
        assertEquals(3, sut.firstMissingPositive(new int[]{1,2,0}));
    }

    @Test
    public void test2() {
        assertEquals(2, sut.firstMissingPositive(new int[]{3,4,-1,1}));
    }

    @Test
    public void test3() {
        assertEquals(1, sut.firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    @Test
    public void test4() {
        assertEquals(3, sut.firstMissingPositive(new int[]{4, 10, 1, 2, -3, 0}));
    }
}