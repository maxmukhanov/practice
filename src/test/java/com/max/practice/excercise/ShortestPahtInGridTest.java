package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ShortestPahtInGridTest {
  private ShortestPahtInGrid shortestPahtInGrid = new ShortestPahtInGrid();

  @Test
  public void case1() {
    int[][] grid = new int[][]{
        {1, 1, 1},
        {1, 0, 1},
        {1, 9, 0}
    };

    int path = shortestPahtInGrid.shortestPath(grid);

    assertThat(path).isEqualTo(3);
  }

  @Test
  public void case2() {
    int[][] grid = new int[][]{
        {1, 1, 1},
        {1, 0, 1},
        {1, 9, 1}
    };

    int path = shortestPahtInGrid.shortestPath(grid);

    assertThat(path).isEqualTo(3);
  }

  @Test
  public void noPath() {
    int[][] grid = new int[][]{
        {1, 1, 1},
        {1, 0, 1},
        {0, 9, 0}
    };

    int path = shortestPahtInGrid.shortestPath(grid);

    assertThat(path).isEqualTo(-1);
  }

  @Test
  public void case3() {
    int[][] grid = new int[][]{
        {1, 0, 1, 9},
        {1, 0, 1, 0},
        {1, 1, 1, 0}
    };

    int path = shortestPahtInGrid.shortestPath(grid);

    assertThat(path).isEqualTo(7);
  }
}