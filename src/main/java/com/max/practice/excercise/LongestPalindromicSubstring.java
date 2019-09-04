package com.max.practice.excercise;

public class LongestPalindromicSubstring {


  /*
   * Brute force solution O(N^3)
   *
   * Expand around center O(N^2)
   *
   * */
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;

    int max = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > max) {
        max = len;
        start = i - (len - 1) / 2;
      }
    }

    return s.substring(start, start + max);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    return right - left - 1;
  }

  private boolean isPal(String s, int lo, int hi) {
    while (lo < hi) {
      if (s.charAt(lo) != s.charAt(hi)) return false;
      lo++;
      hi--;
    }
    return true;
  }
}
