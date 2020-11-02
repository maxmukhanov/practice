package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class KSmallestElementInSortedMatrixTest {
    KSmallestElementInSortedMatrix sut = new KSmallestElementInSortedMatrix();

    @Test
    public void test1() {
        assertEquals(13, sut.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

    @Test
    public void test2() {
        assertEquals(8, sut.kthSmallest(new int[][]{{1, 5, 12}, {4, 11, 13}, {8, 13,Integer.MAX_VALUE}}, 4));
        assertEquals(11, sut.kthSmallest(new int[][]{{1, 5, 12}, {4, 11, 13}, {8, 13,Integer.MAX_VALUE}}, 5));
    }
    @Test
    public void test3() {
        assertEquals(15, sut.kthSmallest(new int[][]{{15}}, 1));
    }

}