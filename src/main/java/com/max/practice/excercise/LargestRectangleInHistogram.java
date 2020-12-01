package com.max.practice.excercise;

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {

    //time O(n), space O(n)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int largest = 0;
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> st = new Stack<>();

        int i = 0;
        while (i < heights.length) {
            int pos = i;
            while (!st.isEmpty() && st.peek() >= heights[i]) {
                pos = positions.pop();
                int size = st.pop() * (i - pos);
                largest = Math.max(largest, size);
            }
            st.push(heights[i]);
            positions.push(pos);

            i++;
        }

        while (!st.empty()) {
            int size = st.pop() * (i - positions.pop());
            largest = Math.max(largest, size);
        }

        return largest;
    }
}
