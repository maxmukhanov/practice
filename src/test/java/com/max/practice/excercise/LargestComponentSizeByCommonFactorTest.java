package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestComponentSizeByCommonFactorTest {
    private LargestComponentSizeByCommonFactor sut = new LargestComponentSizeByCommonFactor();

    @Test
    public void test1() {
        assertEquals(4, sut.largestComponentSize(new int[]{4,6,15,35}));
    }

    @Test
    public void test2() {
        assertEquals(2, sut.largestComponentSize(new int[]{20,50,9,63}));
    }

    @Test
    public void test3() {
        assertEquals(8, sut.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
    }
}