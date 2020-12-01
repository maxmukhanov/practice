package com.max.practice.excercise;

import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumSubarraysMins {
    private static final int mod = 1000000007;

    // result = sum(A[i] * f(i))
    //f(i) - number of subarrays in which A[i] is a mininum
    // f(i) - leftCount[i] * rightCount[i]
    //use stack to keep stack of the count of subarrays at which a[i] is minimum
    //fill leftCount[i] from left to right, then fill rightCount[i] from right to left. Use monotonic increasing stack
    public int sumSubarrayMins(int[] arr) {
        long sum = 0;

        int n = arr.length;
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];

        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!st.isEmpty() && st.peek()[0] > arr[i]) {
                count += st.pop()[1];
            }
            st.push(new int[]{arr[i], count});
            leftCount[i] = count;
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!st.isEmpty() && st.peek()[0] >= arr[i]) {
                count += st.pop()[1];
            }
            st.push(new int[]{arr[i], count});
            rightCount[i] = count;
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) leftCount[i] * rightCount[i] * arr[i]) % mod;
        }

        return (int) sum;
    }
}
