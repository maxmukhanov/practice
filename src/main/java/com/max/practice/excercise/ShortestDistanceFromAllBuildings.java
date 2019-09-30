package com.max.practice.excercise;

import java.util.LinkedList;
import java.util.Queue;


public class ShortestDistanceFromAllBuildings {
  private int[] x = new int[]{-1, 0, 0, 1};
  private int[] y = new int[]{0, -1, 1, 0};

//  BFS starting at each building.
//  Keep track of local distance and global distance from one building to all other.
//  Also keep track if you can reach from one building to all other buildings
  public int shortestDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] dist = new int[n][m];
    int[][] reach = new int[n][m];


    int buildNum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          buildNum++;

          bfs(i, j, n, m, grid, dist, reach);
        }
      }
    }

    int globalMin = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0 && reach[i][j] == buildNum) {
          globalMin = Math.min(globalMin, dist[i][j]);
        }
        }
      }

    return globalMin != Integer.MAX_VALUE ? globalMin : -1;
  }

  private void bfs(int i, int j, int n, int m, int[][] grid, int[][] dist, int[][] reach) {
    boolean[][] seen = new boolean[n][m];

    int[][] localDist = new int[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    seen[i][j] = true;

    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] point = queue.poll();
        i = point[0];
        j = point[1];

        int moves = 4;
        for (int k = 0; k < moves; k++) {
          int ii = i + x[k];
          int jj = j + y[k];

          if (ii >= 0 && ii < n && jj >= 0 && jj < m && grid[ii][jj] == 0 && !seen[ii][jj]) {
            queue.offer(new int[]{ii, jj});
            seen[ii][jj] = true;
            reach[ii][jj]++;
            localDist[ii][jj] = level;
            dist[ii][jj] += localDist[ii][jj];
          }
        }
      }
      level++;
    }
  }


}
