package com.max.practice.excercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class WildcardMatchingTest {

    private WildcardMatching sut = new WildcardMatching();

    @Test
    public void shouldMatchEmptyStringToEmptyPattern() {
        assertTrue(sut.isMatch("", ""));
    }

    @Test
    public void shouldMatchEmptyStringToStarPattern() {
        assertTrue(sut.isMatch("", "*"));
    }

    @Test
    public void shouldMatchAnyStringToStarPattern() {
        assertTrue(sut.isMatch("abdc", "*"));
    }

    @Test
    public void shouldMatchStringToLeadingStarPattern() {
        assertTrue(sut.isMatch("abdc", "*dc"));
    }

    @Test
    public void shouldMatchStringToAllQuestionPattern() {
        assertTrue(sut.isMatch("abdc", "????"));
    }

    @Test
    public void shouldMath1() {
        assertTrue(sut.isMatch("mississippi","m*si*"));
    }

    @Test
    public void shouldMath2() {
        assertTrue(sut.isMatch("abcabczzzde", "*abc???de*"));
    }

    @Test
    public void shouldNotMath1() {
        assertFalse(sut.isMatch("aab", "c*a*b"));
    }
}