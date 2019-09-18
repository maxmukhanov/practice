package com.max.practice.excercise;


public class KMPStringMatching {

//  Brute for pattern matching O(mn), where m - length of text and n - length of pattern
//  Knuth Morris Pratt time O(m + n) and space O(n) - to build prefix-suffix table
  public int indexOf(String text, String pattern) {
    int[] ps = buildPrefixSuffixTable(pattern);

    int i = 0;
    int k = 0;

    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(k)) {
        i++;
        k++;
      } else {
        k = k != 0 ? ps[k - 1] : 0;
        if (text.charAt(i) == pattern.charAt(k)) {
          i++;
          k++;
        } else {
          i++;
        }
      }
      if (k == pattern.length()) return i - k;
    }

    return -1;
  }

  int[] buildPrefixSuffixTable(String pattern) {
    int [] ps = new int[pattern.length()];
    int j = 0, i = 1;


    while (i < ps.length) {
      if (pattern.charAt(j) == pattern.charAt(i)) {
        ps[i] = j + 1;
        i++;
        j++;
      } else {
        if (j == 0) {
          i++;
        } else {
          j = ps [j - 1];
        }
      }
    }

    return ps;
  }
}
