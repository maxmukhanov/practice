package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AnagramTest {
  private Anagram sut = new Anagram();

  @Test
  public void shouldReturnTrueWhenLowerCaseAnagram() {
    assertThat(sut.isAnagram("ab", "ba")).isTrue();
  }

  @Test
  public void shouldReturnTrueWhenCamelCaseAnagram() {
    assertThat(sut.isAnagram("ab", "Ba")).isTrue();
  }

  @Test
  public void shouldReturnTrueWhenUpperCaseAnagram() {
    assertThat(sut.isAnagram("BA", "AB")).isTrue();
  }
}