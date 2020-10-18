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
    int i = 0, j = 1;


    while (j < ps.length) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        ps[j] = i + 1;
        j++;
        i++;
      } else {
        if (i == 0) {
          j++;
        } else {
          i = ps [i - 1];
        }
      }
    }

    return ps;
  }
}
