package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class InsertIntervalTest {

  private InsertInterval sut = new InsertInterval();

  @Test
  public void shouldMergeIntervals() {
    int[][] intervals = {
        {3, 5},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {6, 10};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 5}, new int[]{6, 10}, new int[]{12, 13});
  }

  @Test
  public void shouldMergeIntervalsAll() {
    int[][] intervals = {
        {3, 5},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {3, 13};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 13});
  }

  @Test
  public void shouldMergeStartEdge() {
    int[][] intervals = {
        {3, 5},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {1, 3};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{1, 5}, new int[]{7, 8}, new int[]{9, 10}, new int[]{12, 13});
  }

  @Test
  public void shouldAddInFront() {
    int[][] intervals = {
        {3, 5},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {1, 2};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{1, 2}, new int[]{3, 5}, new int[]{7, 8}, new int[]{9, 10}, new int[]{12, 13});
  }

  @Test
  public void shouldAddInTail() {
    int[][] intervals = {
        {3, 5},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {15, 16};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 5}, new int[]{7, 8}, new int[]{9, 10}, new int[]{12, 13}, new int[]{15, 16});
  }

  @Test
  public void shouldAddInBetween() {
    int[][] intervals = {
        {3, 4},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {5, 6};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}, new int[]{9, 10}, new int[]{12, 13});
  }

  @Test
  public void shouldMergeOnStartEdgeBetween() {
    int[][] intervals = {
        {3, 4},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {4, 6};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 6}, new int[]{7, 8}, new int[]{9, 10}, new int[]{12, 13});
  }

  @Test
  public void shouldMergeOnEndEdgeBetween() {
    int[][] intervals = {
        {3, 4},
        {7, 8},
        {9, 10},
        {12, 13}
    };
    int[] newInterval = {5, 7};
    assertThat(sut.insert(intervals, newInterval)).containsExactly(new int[]{3, 4}, new int[]{5, 8}, new int[]{9, 10}, new int[]{12, 13});
  }
}