package com.max.practice.excercise;

public class DecodeWays {
  public int numDecodings1(String s) {
    if (s == null || s.length() == 0) return 0;

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i < dp.length; i++) {
      int one = Integer.valueOf(s.substring(i - 1, i));
      int two = Integer.valueOf(s.substring(i - 2, i));
      if (one >= 1 && one <= 9) {
        dp[i] += dp[i - 1];
      }

      if (two >= 10 && two <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }


  public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 2];
    dp[1] = 1;

    for (int i = 0; i < n; i++) {
      int cur = s.charAt(i) - '0';
      int two = 10 * (i - 1 >= 0 ? s.charAt(i - 1) - '0' : 0) + cur;

      if (cur > 0 && cur <= 9){
        dp[i + 2] += dp[i + 1];
      }
      if (two >= 10 && two <= 26) {
        dp[i + 2] += dp[i];
      }

    }

    return dp[n + 1];
  }
}
