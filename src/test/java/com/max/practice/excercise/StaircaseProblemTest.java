package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StaircaseProblemTest {
  private StaircaseProblem sut = new StaircaseProblem();

  @Test
  public void shouldReturn5WhenFourStaircasesRec() {
    assertThat(sut.numWaysRec(4)).isEqualTo(5);
  }

  @Test
  public void shouldReturn5WhenFourStaircasesDp() {
    assertThat(sut.numWaysDp(4)).isEqualTo(5);
  }

  @Test
  public void shouldReturnWhenDynamicNumOfSteps() {
    assertThat(sut.numWays(4, new int[]{1, 2, 6})).isEqualTo(5);
  }
}