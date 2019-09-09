package com.max.practice.excercise;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {
  private Permutations sut = new Permutations();

  @Test
  public void shouldReturnPermutationsForOneNumbers() {
    assertThat(sut.permutations(new Integer[]{4})).containsExactlyInAnyOrder(asList(4));
  }

  @Test
  public void shouldReturnPermutationsForTwoNumbers() {
    assertThat(sut.permutations(new Integer[]{2, 3})).containsExactlyInAnyOrder(asList(2, 3), asList(3, 2));
  }

  @Test
  public void shouldReturnPermutationsForThreeNumbers() {
    assertThat(sut.permutations(new Integer[]{1, 2, 3})).containsExactlyInAnyOrder(
        asList(1, 2, 3),
        asList(1, 3, 2),
        asList(2, 1, 3),
        asList(2, 3, 1),
        asList(3, 1, 2),
        asList(3, 2, 1)
    );
  }
}