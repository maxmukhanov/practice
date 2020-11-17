package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class PositionOfLargeGroupsTest {

    private PositionOfLargeGroups sut = new PositionOfLargeGroups();

    @Test
    public void test1() {
        List<List<Integer>> actual = sut.largeGroupPositions("abcdddeeeeaabbbcd");
        assertThat(actual, contains(
                Lists.newArrayList(3,5),
                Lists.newArrayList(6,9),
                Lists.newArrayList(12,14)));
    }

    @Test
    public void test2() {
        List<List<Integer>> actual = sut.largeGroupPositions("");

        assertThat(actual, hasSize(0));
    }

    @Test
    public void test3() {
        List<List<Integer>> actual = sut.largeGroupPositions("aab");

        assertThat(actual, hasSize(0));
    }

}