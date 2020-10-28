package com.max.practice.excercise;

public class EditLevenshteinDistance {

    public int minDistance(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int [][]dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    }
                }
            }
        }

        return dp[n][m];
    }
}
