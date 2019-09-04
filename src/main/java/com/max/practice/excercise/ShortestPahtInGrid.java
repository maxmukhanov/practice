package com.max.practice.excercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPahtInGrid {

  public int shortestPath(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
    int n = grid.length;
    int m = grid[0].length;

    Set<Integer> visited = new HashSet<>();

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    visited.add(0);

    while (!queue.isEmpty()) {
      int [] node = queue.poll();

      int x = node[0];
      int y = node[1];
      int distance = node[2];

      if (grid[x][y] == 9) {
        return distance;
      }

      //right
      if (x > 0 && !visited.contains(index(x - 1, y, m)) && grid[x - 1][y] != 0) {
        queue.add(new int[]{x - 1, y, distance + 1});
        visited.add(index(x - 1, y, m));
      }

      //up
      if (y > 0 && !visited.contains(index(x, y - 1, m)) && grid[x][y - 1] != 0) {
        queue.add(new int[]{x, y - 1, distance + 1});
        visited.add(index(x, y - 1, m));
      }

      //left
      if (x < n - 1 && !visited.contains(index(x + 1, y, m)) && grid[x + 1][y] != 0) {
        queue.add(new int[]{x + 1, y, distance + 1});
        visited.add(index(x + 1, y, m));
      }

      //down
      if (y < m - 1 && !visited.contains(index(x, y + 1, m)) && grid[x][y + 1] != 0) {
        queue.add(new int[]{x, y + 1, distance + 1});
        visited.add(index(x, y + 1, m));
      }
    }

    return -1;
  }

  private Integer index(int i, int j, int m) {
    return i * m + j;
  }

}
