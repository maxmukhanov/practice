package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class KPairsWithSmallestSumTest {
    private KPairsWithSmallestSum sut = new KPairsWithSmallestSum();

    @Test
    public void test1() {
        List<List<Integer>> actual = sut.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        assertThat(actual).containsExactly(
                Lists.newArrayList(1,2),
                Lists.newArrayList(1,4),
                Lists.newArrayList(1,6));
    }
}