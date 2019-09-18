package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DecodeWaysTest {

  private DecodeWays sut = new DecodeWays();


  @Test
  public void shouldReturn3WhenValid() {
    assertThat(sut.numDecodings("226")).isEqualTo(3);
  }

  @Test
  public void shouldReturnZeroWhenZeroFirstChar() {
    assertThat(sut.numDecodings("0111214124")).isEqualTo(0);
  }

  @Test
  public void shouldReturnZeroWhenTwoOrMoreZerosInARow() {
    assertThat(sut.numDecodings("100")).isEqualTo(0);
  }

  @Test
  public void shouldReturnZeroWhenIfNotValid() {
    assertThat(sut.numDecodings("30")).isEqualTo(0);
  }

  @Test
  public void shouldReturnOne() {
    assertThat(sut.numDecodings("27")).isEqualTo(1);
  }

  @Test
  public void shouldReturnOneWhenOne() {
    assertThat(sut.numDecodings("9")).isOne();
  }

  @Test
  public void shouldReturnZeroWhenOneZero() {
    assertThat(sut.numDecodings("0")).isZero();
  }

  @Test
  public void shouldReturnOneFor101() {
    assertThat(sut.numDecodings("101")).isOne();
  }


  @Test
  public void shouldReturnOneFor110() {
    assertThat(sut.numDecodings("110")).isOne();
  }
}