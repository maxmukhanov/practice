package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class KMPStringMatchingTest {
  private KMPStringMatching sut = new KMPStringMatching();

  @Test
  public void shouldReturnZeroForExactMatch() {
    assertThat(sut.indexOf("abc", "abc")).isZero();
  }

  @Test
  public void shouldReturnZeroWhenPatternIsPrefix() {
    assertThat(sut.indexOf("abcd", "abc")).isZero();
  }

  @Test
  public void shouldReturnOneWhenPatternIsPrefix() {
    assertThat(sut.indexOf("dabcd", "abc")).isOne();
  }

  @Test
  public void shouldReturnIndex() {
    assertThat(sut.indexOf("abc abcdab abcdabcdabde", "abcdabd")).isEqualTo(15);
  }

  @Test
  public void shouldBuildPrefixSuffixTable() {
    assertThat(sut.buildPrefixSuffixTable("aabaabaaa")).containsExactly(0, 1, 0, 1, 2, 3, 4, 5, 2);
  }
}