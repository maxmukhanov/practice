package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        solve(0, new ArrayList<>(), n, ans);


        return ans;
    }

    void solve(int row,  List<int[]> list, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> res = new ArrayList<>();
            for (int[] pos : list) {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    s.append(i == pos[1] ? 'Q' : '.');
                }
                res.add(s.toString());
            }
            ans.add(res);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(list, row, col)) {
                list.add(new int[]{row, col});
                solve(row + 1, list, n, ans);
                list.remove(list.size() - 1);
            }
        }

    }

    boolean isValid(List<int[]> list, int row, int col) {
        for (int[] prev : list) {
            int i = prev[0];
            int j = prev[1];
            if (i == row || j == col || Math.abs(i - row) == Math.abs(j - col)) return false;
        }

        return true;
    }
}
