package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestIncreacingSubsequeceTest {
  private LongestIncreacingSubsequece sut = new LongestIncreacingSubsequece();

  @Test
  public void shouldReturnFourForLIS() {
    assertThat(sut.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})).isEqualTo(4);
  }

  @Test
  public void shouldReturnTwoForLIS() {
    assertThat(sut.lengthOfLIS(new int[]{-2, -1})).isEqualTo(2);
  }

  @Test
  public void shouldReturnOneForLIS() {
    assertThat(sut.lengthOfLIS(new int[]{9})).isEqualTo(1);
  }

  @Test
  public void shouldReturnOneForLISWhenSame() {
    assertThat(sut.lengthOfLIS(new int[]{2,2})).isEqualTo(1);
  }

  @Test
  public void shouldReturnThree() {
    assertThat(sut.lengthOfLIS(new int[]{4,10,4,3,8,9})).isEqualTo(3);
  }

  @Test
  public void shouldReturnThree2() {
    assertThat(sut.lengthOfLIS(new int[]{1, 5, 8, 3, 4})).isEqualTo(3);
  }
  @Test
  public void shouldReturnFive() {
    assertThat(sut.lengthOfLIS(new int[]{5, 1, 8, 2, 3, 9, 10})).isEqualTo(5);
  }
}