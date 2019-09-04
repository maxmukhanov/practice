package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BulbSwitchTest {
  private BulbSwitch sut = new BulbSwitch();

  @Test
  public void case1() {
    sut.bulbSwitch(5);
  }

  @Test
  public void case2() {
    assertThat(sut.bulbSwitch(8)).isEqualTo(2);
  }
}