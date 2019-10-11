package com.max.practice.excercise;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i < n) sum ^= nums[i];
            sum ^= i;
        }

        return sum;
    }
}
