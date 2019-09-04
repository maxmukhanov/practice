package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PrevPermutationWithOneSwapTest {
  private PrevPermutationWithOneSwap sut = new PrevPermutationWithOneSwap();

  @Test
  public void case1() {
    int[] A = new int[]{3, 2, 1};

    sut.prevPermOpt1(A);

    assertThat(A).containsExactly(3, 1, 2);
  }
}