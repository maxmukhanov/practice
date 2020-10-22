package com.max.practice.excercise;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
//    return lenDP(nums);
    return lenDPBinarySearch(nums);
  }

  //time O(NlogN), space O(N)
  private int lenDPBinarySearch(int []nums) {
    int n = nums.length;
    int [] dp = new int[n];

    int len = 0;

    for (int num: nums) {
      int pos = Arrays.binarySearch(dp, 0, len, num);
      if (pos < 0) pos = -(pos + 1);
      dp[pos] = num;
      if (pos == len) len++;
    }

    return len;
  }

//  time O(N), space O(N)
  private int lenDP(int nums[]) {
    if (nums == null || nums.length == 0) return 0;

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      max = Math.max(max, dp[i]);
    }

    return max;
  }

//  time O(2^N), space O(N) - stack
  private int lenLIS(int[] nums, int prev, int i, int len) {
    if (i >= nums.length) return len;


    int num = nums[i];

    int max = len;
    if (num > prev) {
      max = Math.max(max, lenLIS(nums, num, i + 1, len + 1));
      max = Math.max(max, lenLIS(nums, prev, i + 1, len));
    } else {
      max = Math.max(max, lenLIS(nums, prev, i + 1, len));
      max = Math.max(max, lenLIS(nums, num, i + 1, 1));
    }

    return max;
  }
}
