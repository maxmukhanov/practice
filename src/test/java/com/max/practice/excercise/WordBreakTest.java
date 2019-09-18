package com.max.practice.excercise;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

public class WordBreakTest {
  private WordBreak sut = new WordBreak();

  @Test
  public void shouldFindBreak() {
    assertThat(sut.wordBreak("catsandog", asList("cats", "and", "an", "dog"))).isTrue();
  }

  @Test
  public void shouldNotFindBreak() {
    assertThat(sut.wordBreak("catsandog", asList("cats", "and", "dog"))).isFalse();
  }
}