package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FindInSortedArrayTest {
  private FindInSortedArray sut = new FindInSortedArray();

  @Test
  public void shouldFindLeft() {
    assertThat(sut.findLeftIndex(new int[]{5, 7, 7, 8, 8, 10}, 8)).isEqualTo(3);
  }

  @Test
  public void shouldFindRight() {
    assertThat(sut.findRightIndex(new int[]{5, 7, 7, 8, 8, 10}, 8, 3)).isEqualTo(4);
  }
}