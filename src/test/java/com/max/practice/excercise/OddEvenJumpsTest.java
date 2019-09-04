package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OddEvenJumpsTest {
  private OddEvenJumps sut = new OddEvenJumps();

  @Test
  public void case1() {
    int[] A = new int[]{10, 13, 12, 14, 15};
    int actual = sut.oddEvenJumps(A);

    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void case2() {
    int[] A = new int[]{2,3,1,1,4};
    int actual = sut.oddEvenJumps(A);

    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void case3() {
    int[] A = new int[]{5,1,3,4,2};
    int actual = sut.oddEvenJumps(A);

    assertThat(actual).isEqualTo(3);
  }
}