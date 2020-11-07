package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCalendarITest {
    private MyCalendarI sut = new MyCalendarI();

    @Test
    public void test1() {
        assertTrue(sut.book(10, 20));
        assertTrue(sut.book(25, 30));
        assertFalse(sut.book(15,21));
        assertFalse(sut.book(20, 40));
        assertTrue(sut.book(20,25));

        assertEquals(3, sut.size());
    }

    @Test
    public void test2() {
        //["MyCalendar","book","book","book","book","book"]
        //[[],[37,50],[33,50],[4,17],[35,48],[8,25]]
        //[null,true,false,true,false,false]
        assertTrue(sut.book(37,50));
        assertFalse(sut.book(33,50));
        assertTrue(sut.book(4,17));
        assertFalse(sut.book(35,48));
        assertFalse(sut.book(8,25));

    }

    @Test
    public void test3() {
        int k = 1;

        char ch = (char) (k + 'a');

        System.out.println(ch);

        System.out.println((int) ('{' - 'a'));
    }
}