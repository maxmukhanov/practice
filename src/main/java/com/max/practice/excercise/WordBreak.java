package com.max.practice.excercise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j >= 0; j--) {
        String word = s.substring(j, i + 1);
        if (set.contains(word) && dp[j]) dp[i + 1] = true;

      }
    }

    return dp[s.length()];
  }
}
