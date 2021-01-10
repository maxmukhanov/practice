package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralArrayTest {
    private SpiralArray sut = new SpiralArray();

    @Test
    public void generateArraysOfSize2() {
        int[][] expected = new int[][]{
                {1, 2},
                {4, 3}
        };

        int[][] actual = sut.spiral(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void generateArraysOfSize3() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7,6,5}
        };

        int[][] actual = sut.spiral(3);
        assertArrayEquals(expected, actual);
    }
}