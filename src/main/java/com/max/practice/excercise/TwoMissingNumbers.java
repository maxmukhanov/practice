package com.max.practice.excercise;

public class TwoMissingNumbers {

//    Idea here to use XOR x^x = 0, x^y^x = y
//    It's easy to find one missing number with XOR
//    We should find sum of two missing numbers (n*(n+1)/2 - total sum) - numsSum
//    We know that those two number are in 1..n and they are distinct
//    So one of the numbers is >= sum/2 and other < sum/2
//    We will XOR 1..sum/2 and nums where elements <= sum/2 - it's gonna be our fist number
//    XOR sum/2 ...n and nums where elements > sum/2 - it's gonna be our second number

    public int[] missingNumbers(int [] nums) {
        int n = nums.length + 2;


        int origSum = n * (n + 1) / 2;
        int numsSum = 0;

        for (int num : nums) numsSum += num;

        int pivot = (origSum - numsSum) / 2;

        int totalLeftXor = 0;
        int numsLeftXor = 0;
        int totalRightXor = 0;
        int numsRightXor = 0;

        for (int i = 1; i <= pivot; i++) totalLeftXor ^= i;
        for (int i = pivot + 1; i <= n; i++) totalRightXor ^= i;
        for (int num : nums) {
            if (num <= pivot) numsLeftXor ^= num;
            else numsRightXor ^= num;
        }

        return new int[]{totalLeftXor ^ numsLeftXor, totalRightXor ^ numsRightXor};
    }

}
