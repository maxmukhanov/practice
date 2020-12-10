package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class TilingRectangleTest {
    private TilingRectangle sut = new TilingRectangle();

    @Test
    public void test1() {
        assertEquals(3, sut.tilingRectangle(2, 3));
    }

    @Test
    public void test2() {
        assertEquals(5, sut.tilingRectangle(5, 8));
    }

    @Test
    public void test3() {
        assertEquals(6, sut.tilingRectangle(11, 13));
    }

    @Test
    public void test4() {
        assertEquals(1, sut.tilingRectangle(13, 13));
    }
}