package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneEditApartTest {
    private OneEditApart sut = new OneEditApart();

    @Test
    public void shouldBeOneEditApartInsert() {
        assertTrue(sut.isOneEditApart("cat", "cats"));
    }

    @Test
    public void shouldBeOneEditApartReplace() {
        assertTrue(sut.isOneEditApart("cat", "cut"));
    }

    @Test
    public void shouldBeOneEditApartRemove() {
        assertTrue(sut.isOneEditApart("cat", "cast"));
    }

    @Test
    public void test1() {
        assertFalse(sut.isOneEditApart("cat", "cuts"));
    }

    @Test
    public void shouldReturnFalseWhenMoreThanOneEdit() {
        assertFalse(sut.isOneEditApart("cat", "act"));
    }

    @Test
    public void shouldReturnFalseWhenMoreThanOneEditLen() {
        assertFalse(sut.isOneEditApart("cat", "asfasfd"));
    }



}