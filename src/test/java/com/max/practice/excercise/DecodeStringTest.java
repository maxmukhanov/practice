package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DecodeStringTest {

  DecodeString decoder = new DecodeString();

  @Test
  public void case1() {
    assertThat(decoder.decodeString("3[a]2[bc]")).isEqualTo("aaabcbc");
  }
}