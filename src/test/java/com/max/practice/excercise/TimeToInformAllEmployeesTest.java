package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeToInformAllEmployeesTest {
    private TimeToInformAllEmployees sut = new TimeToInformAllEmployees();

    @Test
    public void test1() {
        assertEquals(0, sut.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
    }

    @Test
    public void test2() {
        assertEquals(1, sut.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }

    @Test
    public void test3() {
        assertEquals(21, sut.numOfMinutes(7, 6, new int[]{1,2,3,4,5,6,-1}, new int[]{0,6,5,4,3,2,1}));
    }

    @Test
    public void test4() {
        assertEquals(3, sut.numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
    }

    @Test
    public void test5() {
        assertEquals(1076, sut.numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914}));
    }
}