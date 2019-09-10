package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CoinChangeTest {
  private CoinChange sut = new CoinChange();

  @Test
  public void shouldReturnMinCoinChange() {
    assertThat(sut.minCoins(new int[]{1, 2, 5}, 11)).isEqualTo(3);
  }

  @Test
  public void shouldReturnMinCoinChange2() {
    assertThat(sut.minCoins(new int[]{1, 2, 5}, 5)).isEqualTo(1);
  }

  @Test
  public void shouldReturnMinusOneWhenChangeCantBeProducesd() {
    assertThat(sut.minCoins(new int[]{4, 5}, 7)).isEqualTo(-1);
  }
}