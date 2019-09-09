package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestConsecutiveArrayTest {
  private LongestConsecutiveArray sut = new LongestConsecutiveArray();

  @Test
  public void shouldReturn3ForLongest() {
    assertThat(sut.longestConsecutive(new int[]{0, 4, 1, 2, 6, 7})).isEqualTo(3);
  }

  @Test
  public void shouldReturnOneWhenNoConsecutive() {
    assertThat(sut.longestConsecutive(new int[]{4, 6, 8})).isEqualTo(1);
  }

  @Test
  public void shouldReturnZeroWhenNoElements() {
    assertThat(sut.longestConsecutive(new int[]{})).isEqualTo(0);
  }

  @Test
  public void shouldReturnOneWhenOnlyOne() {
    assertThat(sut.longestConsecutive(new int[]{4})).isEqualTo(1);
  }
}