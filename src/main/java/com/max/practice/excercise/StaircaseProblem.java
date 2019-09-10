package com.max.practice.excercise;

public class StaircaseProblem {

  public int numWaysRec(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    return numWaysRec(n - 1) + numWaysRec(n - 2);
  }

  public int numWaysDp(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int prev1 = 1;
    int prev2 = 1;
    int result = -1;
    for (int i = 2; i <= n; i++) {
      result = prev1 + prev2;
      prev2 = prev1;
      prev1 = result;
    };

    return result;
  }

  public int numWays(int n, int[] steps) {
    if (n == 0) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      int total = 0;
      for (int j = 0; j < steps.length; j++) {
        if(i - steps[j] >= 0) total += dp[i - steps[j]];
      }
      dp[i] = total;
    }

    return dp[n];
  }

}
