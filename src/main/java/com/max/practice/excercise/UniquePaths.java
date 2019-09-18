package com.max.practice.excercise;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    if (m <= 0 || n <= 0) return 0;

    int[] dp = new int[n];

    for (int i = 0; i < m; i++) {
      int[] dp1 = new int[n];
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp1[j] = 1;
        } else {
          dp1[j] = dp1[j - 1] + dp[j];
        }

      }
      dp = dp1;
    }

    return dp[n - 1];
  }
}
