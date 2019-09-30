package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestDistanceFromAllBuildingsTest {
  private ShortestDistanceFromAllBuildings sut = new ShortestDistanceFromAllBuildings();

  @Test
  public void shouldReturn7() {
    int[][] grid = new int[][]{
        {1, 0, 2, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0}
    };

    assertThat(sut.shortestDistance(grid)).isEqualTo(7);
  }
  
  @Test
  public void shouldReturn88() {
    int[][] grid = new int[][]{
        {1,1,1,1,1,0},
        {0,0,0,0,0,1},
        {0,1,1,0,0,1},
        {1,0,0,1,0,1},
        {1,0,1,0,0,1},
        {1,0,0,0,0,1},
        {0,1,1,1,1,0}
    };

    assertThat(sut.shortestDistance(grid)).isEqualTo(88);
  }

  @Test
  public void shouldNotAblePassThroughBuiling() {
    int[][] grid = new int[][]{
        {1, 1},
        {0, 1}
    };

    assertThat(sut.shortestDistance(grid)).isEqualTo(-1);
  }
}