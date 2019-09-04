package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KnightProbabilityTest {
  private KnightProbability knightProbability = new KnightProbability();

  @Test
  public void case1() {
    double actual = knightProbability.knightProbability(3, 3, 0, 0);


  }

  @Test
  public void case2() {
    double actual = knightProbability.knightProbability(3, 2, 0, 0);

    assertThat(actual).isEqualTo(0.0625);
  }
}