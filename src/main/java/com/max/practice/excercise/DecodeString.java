package com.max.practice.excercise;

import java.util.Stack;

public class DecodeString {

  public String decodeString(String s) {
    Stack<Integer> timesSt = new Stack<>();
    Stack<String> st = new Stack<>();
    st.push("");

    int i = 0;

    while (i < s.length()) {
      char symbol = s.charAt(i);

      if (symbol >= '0' && symbol <= '9') {
        int start = i;

        while (s.charAt(i + 1) >= '1' && s.charAt(i + 1) <= '9') i++;
        timesSt.push(Integer.valueOf(s.substring(start, i + 1)));
      } else if (symbol == '[') {
        st.push("");
      } else if (symbol == ']') {
        int times = timesSt.pop();
        StringBuilder sb = new StringBuilder();
        while (times-- > 0) sb.append(st.peek());
        st.pop();
        st.push(st.pop() + sb.toString());

      } else {
        st.push(st.pop() + symbol);
      }

      i++;
    }


    return st.pop();
  }
}
