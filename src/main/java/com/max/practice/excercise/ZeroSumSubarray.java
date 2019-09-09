package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray {

  public int[] zeroSumSubarray(int[] nums) {
    Map<Integer, Integer> sumToIndex = new HashMap<>();

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      sum += num;

      if (num == 0) return Arrays.copyOfRange(nums, i, i + 1);
      if (sum == 0) return Arrays.copyOfRange(nums, 0, i + 1);
      if (sumToIndex.containsKey(sum)) return Arrays.copyOfRange(nums, sumToIndex.get(sum) + 1, i + 1);

      sumToIndex.put(sum, i);
    }
    return new int[]{};
  }


}
