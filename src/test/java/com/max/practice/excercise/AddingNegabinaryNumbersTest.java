package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AddingNegabinaryNumbersTest {
  private AddingNegabinaryNumbers sut = new AddingNegabinaryNumbers();

  @Test
  public void case1() {
    int[] actual = sut.addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1});

    assertThat(actual).containsExactly(1,0,0,0,0);
  }

  @Test
  public void case2() {
    int[] actual = sut.addNegabinary(new int[]{1}, new int[]{1, 1});

    assertThat(actual).containsExactly(0);
  }

  @Test
  public void test1() {
    String val = "abc||hi";

    assertThat(val.substring(val.indexOf("||") + "||".length())).isEqualTo("hi");
  }

}