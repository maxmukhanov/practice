package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleInHistogramTest {
    private LargestRectangleInHistogram sut = new LargestRectangleInHistogram();

    @Test
    public void test1() {
        assertEquals(10, sut.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    @Test
    public void test2() {
        assertEquals(4, sut.largestRectangleArea(new int[]{3,2,1}));
    }

    @Test
    public void test3() {
        assertEquals(6, sut.largestRectangleArea(new int[]{1,2,3,2,1}));
    }

    @Test
    public void test4() {
        assertEquals(5, sut.largestRectangleArea(new int[]{1,3,2,1,2}));
    }
}