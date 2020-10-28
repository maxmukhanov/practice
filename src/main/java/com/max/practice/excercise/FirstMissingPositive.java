package com.max.practice.excercise;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        nums = Arrays.copyOf(nums, nums.length + 1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] >= n) nums[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            nums[nums[i] % n] += n;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] / n == 0) return i;
        }

        return n;
    }
}
