package com.max.practice.excercise;

public class IslandCount {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return count;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char [][] grid, int i, int j, int n, int m) {
        grid[i][j] = '0';

        int [][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int[] dir: directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            System.out.println("ii=" + ii + "jj=" + jj + "n=" + n + "m=" + m);
            if (ii >= 0 && ii < n && jj >= 0 && jj < m && grid[ii][jj] == '1'){
                dfs(grid, ii, jj, n, m);
            }
        }
    }
}
