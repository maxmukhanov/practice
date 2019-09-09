package com.max.practice.excercise;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveArray {
  public int longestConsecutive(int[] nums) {
    int max = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int len = 0;
        while (set.contains(num++)) len++;

        max = Math.max(max, len);
      }
    }


    return max;
  }
}
