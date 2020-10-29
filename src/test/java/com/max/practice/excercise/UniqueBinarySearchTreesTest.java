package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTest {

    private UniqueBinarySearchTrees sut = new UniqueBinarySearchTrees();

    @Test
    public void testN0() {
        assertEquals(1, sut.numTrees(0));
    }

    @Test
    public void testN1() {
        assertEquals(1, sut.numTrees(1));
    }
    @Test
    public void testN2() {
        assertEquals(2, sut.numTrees(2));
    }
    @Test
    public void testN3() {
        assertEquals(5, sut.numTrees(3));
    }

    @Test
    public void testN4() {
        assertEquals(14, sut.numTrees(4));
    }

    @Test
    public void testN5() {
        assertEquals(42, sut.numTrees(5));
    }
}