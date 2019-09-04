package com.max.practice.excercise;

import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TruckShortestPathTest {
  private TruckShortestPath sut = new TruckShortestPath();

  @Test
  public void case1() {
    int distance = sut.minimumDistance(3, 3, Lists.newArrayList(
        Lists.newArrayList(1, 0, 0),
        Lists.newArrayList(1, 0, 0),
        Lists.newArrayList(1, 9, 1)
    ));

    assertThat(distance).isEqualTo(3);
  }
}