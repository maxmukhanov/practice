package com.max.practice.excercise;

import javax.print.DocFlavor;
import java.util.Stack;

public class SmallestSubsequeseOfDistinctCharacters {

  public String smallestSubsequence(String text) {
    int[] last = new int[26];
    for (int i = 0; i < text.length(); i++) {
      last[text.charAt(i) - 'a'] = i;
    }

    boolean[] seen = new boolean[26];
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (seen[ch - 'a']) continue;
      while (!st.isEmpty() && st.peek() > ch && i < last[st.peek() - 'a']) {
        seen[st.pop() - 'a'] = false;
      }

      st.push(ch);
      seen[ch - 'a'] = true;

    }

    StringBuilder sb = new StringBuilder();

    while (!st.isEmpty()) sb.append(st.pop());
    return sb.toString();
  }
}
