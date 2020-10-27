package com.max.practice.excercise;

import java.util.*;

public class WaterFlow {
    private static final char Y = 'Y';
    private static final char N = 'N';
    private static final char U = 'U';
    private static final int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        char[][] reachA = new char[n][m];
        char[][] reachP = new char[n][m];
        for (int i = 0; i < n; i++) {

        }
        for(int i = 0; i < n; i++){
            Arrays.fill(reachA[i], U);
            Arrays.fill(reachP[i], U);
            reachA[i][m - 1] = Y;
            reachP[i][0] = Y;
        }
        for(int j = 0; j < m; j++) {
            reachA[n - 1][j] = Y;
            reachP[0][j] = Y;
        }

        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (canReach(matrix, i, j, n, m, reachA, seen) &&
                        canReach(matrix, i, j, n, m, reachP, seen)) {
                    res.add(Arrays.asList(i,j));
                }
            }
        }


        return res;
    }

    boolean canReach(int[][] matrix, int i, int j, int n, int m, char[][] reach, Set<Integer> seen){
        if(reach[i][j] == U) {
            seen.add(i*m + j);
            for(int []dir: directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];

                if(ii >= 0 && ii < n && jj >= 0 && jj < m &&
                        matrix[ii][jj] <= matrix[i][j] && !seen.contains(ii*m + jj)) {
                    if (canReach(matrix, ii, jj, n, m, reach, seen)) {
                        reach[i][j] = Y;
                        break;
                    }
                }
            }
            seen.remove(i*m + j);
            reach[i][j] = reach[i][j] == U ? N : reach[i][j];

        }

        return reach[i][j] == Y;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        int [][] res = new int[1][1];

        return res;
    }
}
