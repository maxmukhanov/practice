package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

//https://leetcode.com/problems/edit-distance/
public class EditLevenshteinDistanceTest {
    private EditLevenshteinDistance sut = new EditLevenshteinDistance();

    @Test
    public void test1() {
        assertEquals(3, sut.minDistance("horse", "ros"));
    }

    @Test
    public void test2() {
        assertEquals(5, sut.minDistance("intention", "execution"));
    }
}