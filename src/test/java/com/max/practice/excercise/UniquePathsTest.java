package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UniquePathsTest {
  private UniquePaths sut = new UniquePaths();

  @Test
  public void shouldReturn3UniquePaths() {
    assertThat(sut.uniquePaths(3, 2)).isEqualTo(3);
  }

  @Test
  public void shouldReturn28UniquePaths() {
    assertThat(sut.uniquePaths(7, 3)).isEqualTo(28);
  }
}