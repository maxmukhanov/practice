package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SmallestSubsequeseOfDistinctCharactersTest {
  private SmallestSubsequeseOfDistinctCharacters sut = new SmallestSubsequeseOfDistinctCharacters();

  @Test
  public void case1() {
    assertThat(sut.smallestSubsequence("cdadabcc")).isEqualTo("adbc");
  }

  @Test
  public void case2() {
    assertThat(sut.smallestSubsequence("abcd")).isEqualTo("abcd");
  }

  @Test
  public void case3() {
    assertThat(sut.smallestSubsequence("ecbacba")).isEqualTo("eacb");
  }

  @Test
  public void case4() {
    assertThat(sut.smallestSubsequence("")).isEqualTo("");
  }
}