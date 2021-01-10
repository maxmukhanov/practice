package com.max.practice.excercise;

public class SpiralArray {

    public int[][] spiral(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        int[][] ans = new int[n][n];
        int [] dc = new int[]{1,0,-1,0};
        int [] dr = new int[]{0,1,0,-1};
        int num = 0, r = 0, c = 0, dir = 0, limit = n*n;

        while(++num <= limit) {
            ans[r][c] = num;

            r += dr[dir];
            c += dc[dir];
            if (isInvalid(ans, r, c, n)) {
                r -= dr[dir];
                c -= dc[dir];
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return ans;
    }

    private boolean isInvalid(int[][] ans, int r, int c, int n) {
        return r < 0 || r >= n || c < 0 || c >= n || ans[r][c] != 0;
    }
}
