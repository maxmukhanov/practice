package com.max.practice.excercise;

public class Anagram {

  public boolean isAnagram(String one, String two) {
    if (one == null || two == null || one.length() != two.length()) return false;

    int[] letters = new int[26];
    for (int i = 0; i < one.length(); i++) {

      letters[index(one.charAt(i))]++;
      letters[index(two.charAt(i))]--;
    }

    for (int letter : letters) {
      if (letter != 0) return false;
    }

    return true;
  }

  private int index(char ch) {
    if (ch >= 'a' && ch <= 'z') {
      return ch - 'a';
    } else {
      return ch - 'A';
    }
  }
}
