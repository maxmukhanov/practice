package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AlienDictionaryTest {
  private AlienDictionary sut = new AlienDictionary();

  @Test
  public void shouldReturnOrder() {
    assertThat(sut.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"})).isEqualTo("wertf");
  }

  @Test
  public void shouldReturnEmptyStringWhenWrongOrder() {
    assertThat(sut.alienOrder(new String[]{"x", "y", "x"})).isEqualTo("");
  }

  @Test
  public void shouldReturnEmptyStringWhenWrongOrder2() {
    assertThat(sut.alienOrder(new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"})).isEqualTo("");
  }

  @Test
  public void onlyOneWord() {
    assertThat(sut.alienOrder(new String[]{"xzf"})).isEqualTo("xzf");
  }

}