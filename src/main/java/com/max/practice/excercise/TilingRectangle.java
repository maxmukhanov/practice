package com.max.practice.excercise;

//https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares/
public class TilingRectangle {
    int ans = Integer.MAX_VALUE;

    //backtracking. covered shows whether this area is used already.
    //we need to fulfill every row, by placing tile in each column till the end
    public int tilingRectangle(int n, int m) {
        if (n == m) return 1;
        solve(0, 0, n, m, new boolean[n][m], 0);

        return ans;
    }

    void solve(int row, int col, int n, int m, boolean covered[][], int count) {
        if (count >= ans) return;

        if (row >= n) {
            ans = count;
            return;
        }

        if (col >= m) {
            solve(row + 1, 0, n, m, covered, count);
            return;
        }

        if (covered[row][col]) {
            solve(row, col + 1, n, m, covered, count);
            return;
        }

        for (int tileSize = Math.min(n - row, m - col); tileSize >= 1 && isAvailable(covered, row, col, tileSize); tileSize--) {
            placeTile(row, col, tileSize, covered);
            solve(row, col + 1, n, m, covered, count + 1);
            unPlaceTile(row, col, tileSize, covered);
        }


    }

    private void placeTile(int row, int col, int tileSize, boolean[][] covered) {
        for (int i = row; i < row + tileSize; i++) {
            for (int j = col; j < col + tileSize; j++) {
                covered[i][j] = true;
            }
        }
    }

    private void unPlaceTile(int row, int col, int tileSize, boolean[][] covered) {
        for (int i = row; i < row + tileSize; i++) {
            for (int j = col; j < col + tileSize; j++) {
                covered[i][j] = false;
            }
        }
    }

    private boolean isAvailable(boolean[][] covered, int row, int col, int tileSize) {
        for (int i = row; i < row + tileSize; i++) {
            for (int j = col; j < col + tileSize; j++) {
                if (covered[i][j]) return false;
            }
        }
        return true;
    }

}
