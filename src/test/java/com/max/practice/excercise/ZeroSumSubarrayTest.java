package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ZeroSumSubarrayTest {

  private ZeroSumSubarray sut = new ZeroSumSubarray();

  @Test
  public void shouldReturnWholeArrayWhenSumIsZero() {
    assertThat(sut.zeroSumSubarray(new int[]{1, 2, -3})).containsExactly(1, 2, -3);
  }

  @Test
  public void shouldReturnFirstSubArrayWithZeroSum() {
    assertThat(sut.zeroSumSubarray(new int[]{1, 2, -5, 1, 2, -1})).containsExactly(2, -5, 1, 2);
  }

  @Test
  public void shouldReturnEmptyArrayWhenNoZeroSubarrayFound() {
    assertThat(sut.zeroSumSubarray(new int[]{3, 4, 5})).isEmpty();
  }

  @Test
  public void shouldReturnZeroWhenNoZeroNum() {
    assertThat(sut.zeroSumSubarray(new int[]{1, 3, 0, -4})).containsExactly(0);
  }
}