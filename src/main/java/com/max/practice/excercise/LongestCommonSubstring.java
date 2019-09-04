package com.max.practice.excercise;

public class LongestCommonSubstring {
  public int longestCommonSubstring(String word1, String word2) {
    int longest = 0;
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i < word1.length(); i++) {
      for (int j = 0; j < word2.length(); j++) {
        if (word1.charAt(i) == word2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
          if (dp[i + 1][j + 1] > longest) {
            longest = dp[i + 1][j + 1];
          }
        }
      }
    }

    return longest;
  }
}
