package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class LongestPalindromicSubstringTest {
  private LongestPalindromicSubstring sut = new LongestPalindromicSubstring();

  @Test
  public void case1() {
    assertThat(sut.longestPalindrome("cbbd")).isEqualTo("bb");

  }
  @Test
  public void case2() {
    assertThat(sut.longestPalindrome("bab")).isEqualTo("bab");

  }

  @Test
  public void case3() {
    assertThat(sut.longestPalindrome("bb")).isEqualTo("bb");
  }

  @Test
  public void case4() {
    assertThat(sut.longestPalindrome("ab")).isEqualTo("a");
  }
}