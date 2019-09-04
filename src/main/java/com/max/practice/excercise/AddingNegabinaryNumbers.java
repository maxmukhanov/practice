package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*https://leetcode.com/problems/adding-two-negabinary-numbers/
 *1073. Adding Two Negabinary Numbers
 */
public class AddingNegabinaryNumbers {
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    List<Integer> result = new ArrayList<>();
    int n = arr1.length;
    int m = arr2.length;

    int maxLen = Math.max(n, m);

    Object[] map = new Object[6];
    map[0] = new int[]{0, 1};
    map[1] = new int[]{1, 1};
    map[2] = new int[]{0, 0};
    map[3] = new int[]{1, 0};
    map[4] = new int[]{0, -1};
    map[5] = new int[]{1, -1};


    int carry = 0;
    for (int i = 0; i < maxLen; i++) {
      int a = n > i ? arr1[n - i - 1] : 0;
      int b = m > i ? arr2[m - i - 1] : 0;

      int sum = a + b + carry;

      int[] out = (int[]) map[sum + 2];
      int bit = out[0];
      int nextCarry = out[1];

      result.add(bit);
      carry = nextCarry;
    }

    while (carry != 0) {
      int[] out = (int[]) map[carry + 2];
      int bit = out[0];
      int nextCarry = out[1];

      result.add(bit);
      carry = nextCarry;
    }


    int endIndex = result.size() - 1;
    while (endIndex > 0) {
      if (result.get(endIndex) == 1) break;
      endIndex--;
    }

    int[] arr = new int[endIndex + 1];
    for (int i = 0; i <= endIndex; i++) {
      arr[i] = result.get(endIndex - i);
    }


    return arr;
  }
}
