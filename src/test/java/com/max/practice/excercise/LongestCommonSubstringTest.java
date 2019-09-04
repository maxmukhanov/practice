package com.max.practice.excercise;

import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class LongestCommonSubstringTest {
  private LongestCommonSubstring sut = new LongestCommonSubstring();

  @Test
  public void case1() {
    assertThat(sut.longestCommonSubstring("abcdaf", "zbcdf")).isEqualTo(3);
  }

  @Test
  public void shouldReturnZeroWhenNoCommonSubstring() {
    assertThat(sut.longestCommonSubstring("abc", "defg")).isEqualTo(0);
  }


}